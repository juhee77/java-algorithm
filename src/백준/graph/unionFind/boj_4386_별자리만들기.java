package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_4386_별자리만들기 {
    private static int v, parents[];
    private static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        private double distance;
        private int nodeA;
        private int nodeB;

        public Edge(double distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
       }

        @Override
        public int compareTo(Edge o) {
            if (this.distance < o.distance) return -1;
            else if(this.distance == o.distance)  return 0;
            else return 1;
        }
    }

    private static int findParent(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double result = 0;

        v = Integer.parseInt(br.readLine());// 정점

        parents = new int[v + 1];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
        double arr[][] =new double[v][2];
        //edge 입력
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        //edge 입력
        for (int i = 0; i < v; i++) {
            double nowx = arr[i][0],nowy = arr[i][1];
            for(int j = i+1; j< v; j++){
                double d = Math.sqrt((nowx-arr[j][0])*(nowx-arr[j][0])+(nowy-arr[j][1])*(nowy-arr[j][1]));
                edges.add(new Edge(d,i,j));
            }
        }
        Collections.sort(edges);


        for (int i = 0; i < edges.size(); i++) {
            double cost = edges.get(i).distance;
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.printf("%.2f",result);
    }
}
