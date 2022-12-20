package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13023_ABCDE {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static boolean able=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];
        for(int i=0;i<N&&!able;i++){
            visited[i]=true;
            dfs(0,i);
            visited[i]=false;
        }
        System.out.println(able?1:0);

    }

    private static void dfs(int depth,int now) {
        if(able) return;
        if(depth>=4){
            able = true;
            return;
        }

        for(int e : graph.get(now)){
            if(!visited[e]){
                visited[e]=true;
                dfs(depth+1,e);
                visited[e]=false;
            }
        }
    }
}
