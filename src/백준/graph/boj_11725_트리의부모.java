package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11725_트리의부모 {
    //각 노드에 연결되어있는 노드의 정보를 담음
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //edge수
    private static int edge;
    private static int ans[];

    private static void dfs(int parent,ArrayList<Integer> list){
        for(int i=0;i <list.size();i++){
            int temp = list.get(i);
            if(ans[temp]==0){
                ans[temp] = parent;
                dfs(temp, graph.get(temp));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        edge = Integer.parseInt(br.readLine()) + 1;
         ans = new int[edge];
        //그래프 초기화
        for (int i = 0; i <= edge; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 1; i < edge - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(child).add(parent);
            graph.get(parent).add(child);
        }
        ans[0] = Integer.MAX_VALUE;
        ArrayList<Integer> temp = graph.get(1);
        dfs(1,temp);

        for (int i = 2; i < edge; i++) System.out.println(ans[i]);

    }
}
