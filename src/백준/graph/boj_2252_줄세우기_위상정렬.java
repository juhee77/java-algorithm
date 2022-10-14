package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2252_줄세우기_위상정렬 {
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<Integer>> graphs = new ArrayList<>();
    private static int indegree[];
    private static void toopologySort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now+1+" ");
            for(int next: graphs.get(now)){
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        indegree = new int[n];
        for(int i=0;i<n;i++) graphs.add(new ArrayList<Integer>());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            indegree[e]++;
            graphs.get(s).add(e);
        }
        toopologySort();
    }
}
