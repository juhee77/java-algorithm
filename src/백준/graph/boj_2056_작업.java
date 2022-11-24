package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2056_작업 {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] inDegree;
    private static int[] usedTime;
    private static int[] wastedTime;

    private static int topologicalSort() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                wastedTime[next] = Math.max(wastedTime[now]+usedTime[next],wastedTime[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        //System.out.println(Arrays.toString(wastedTime));
        Arrays.sort(wastedTime);
        return wastedTime[wastedTime.length-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        inDegree = new int[size];
        usedTime = new int[size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            usedTime[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            if (0 < cnt) {
                for (int j = 0; j < cnt; j++) {
                    int temp = Integer.parseInt(st.nextToken()) - 1;
                    inDegree[i]++;
                    graph.get(temp).add(i);
                }
            }
        }
        wastedTime = usedTime.clone();
        System.out.println(topologicalSort());
    }
}
