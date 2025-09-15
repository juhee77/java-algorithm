package 백준.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_17835_면접보는승범이네 {
    private static int N,M,K;
    private static final int INF = (int) 1e6;
    private static List<List<Graph>> graphs = new ArrayList<>();
    private static List<Integer> place = new ArrayList<>();
    public static class Graph implements Comparable<Graph>{
        int next;
        int cost;

        public Graph(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return cost-o.cost;
        }
    }
    //최단 거리에 대한
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            graphs.add(new ArrayList<Graph>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

//            graphs.get(u).add(new Graph(v,c));
            graphs.get(v).add(new Graph(u,c));
        }

        // 면접장 위치(k개)
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            place.add(Integer.parseInt(st.nextToken())-1);
        }

//        System.out.println(place);

        //각 면접장에 대한 택시 최단 경로
        int[] distance = new int[N];
        //면접장에서 각 위치 까지의
        int[] min = new int[N];
        Arrays.fill(min,INF);
        for(int pl : place ){
            Arrays.fill(distance,INF);
            distance[pl] = 0;
            PriorityQueue<Graph> queue = new PriorityQueue<>();
            queue.offer(new Graph(pl, 0));

            while (!queue.isEmpty()) {
                Graph node = queue.poll();
                int now = node.next;
                int dist = node.cost;
                //현재 노드가 이미 방문한 노드라면 지나가기
                if (distance[now] < dist) continue;

                for (Graph next : graphs.get(now)) {
                    int cost = distance[now] + next.cost;
                    //현재 노드 방문후 다른노드 방문하는게 짧은경우
                    if (cost < distance[next.next]) {
                        distance[next.next] = cost;
                        queue.offer(new Graph(next.next, cost));
                    }
                }
            }

            for(int i=0;i<N;i++){
                min[i] = Math.min(min[i],distance[i]);
            }
        }

        int ans = 0;
        int max = min[0];
        for(int i=2;i<N;i++){
            if(ans<min[i]){
                ans = i;
                max = min[i];
            }
        }

        System.out.println((ans+1)+" \n" +max);

    }
}
