package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2644_촌수확인 {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int ans =-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int findOne = Integer.parseInt(st.nextToken())-1;
        int findTwo = Integer.parseInt(st.nextToken())-1;
        int line = Integer.parseInt(br.readLine());

        //*init*/
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n];

        while(line-->0){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken())-1;
            int child = Integer.parseInt(st.nextToken())-1;

            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        visited[findOne] = true;
        dfs(findOne,1,findTwo);
        System.out.println(ans);
    }

    private static void dfs(int findOne, int depth, int findTwo) {
        if(ans!=-1)return;
        for(int e : graph.get(findOne)){
            if(visited[e]) continue;
            if(e==findTwo) {
                ans = depth;
                return;
            }
            visited[e]=true;
            dfs(e,depth+1,findTwo);
        }
    }

}
