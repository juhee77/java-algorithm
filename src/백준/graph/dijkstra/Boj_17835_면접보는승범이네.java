package 백준.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17835_면접보는승범이네 {
    private static int N,M,K;
    private static List<List<Graph>> graphs;
    private static List<Integer> place;
    public static class Graph{
        int end;
        int cost;

        public Graph(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    //최단 거리에 대한
    public static void Main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            graphs.add(new ArrayList());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            graphs.get(u).add(new Graph(v,c));
            graphs.get(v).add(new Graph(u,c));
        }

        // 면접장 위치(k개)
        for(int i=0;i<K;i++){

        }







    }
}
