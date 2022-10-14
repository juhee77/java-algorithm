package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2623_음악프로그램_위상정렬 {
    private static String topologicalSort(ArrayList<ArrayList<Integer>> array,int[] indegree,int n){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            ans.add(now);

            for(int next : array.get(now)){
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }

        if(ans.size()!=n) return "0";
        else {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++) sb.append(ans.get(i)).append("\n");
            return sb.toString();
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int indegree[] = new int[n + 1];
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n+1;i++) array.add(new ArrayList<Integer>());


        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int before = (st.hasMoreTokens())? Integer.parseInt(st.nextToken()):0;

            for(int j=1;j<line;j++){
                int now = Integer.parseInt(st.nextToken());
                array.get(before).add(now);
                indegree[now] ++;
                before=now;
            }
        }
        System.out.println(topologicalSort(array,indegree,n));
    }
}
