package 백준.graph.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1005_ACMCraft {
    private static final StringBuilder sb = new StringBuilder();

    private static int topologicalSort(ArrayList<ArrayList<Integer>> outarray, ArrayList<ArrayList<Integer>> inarray, int goal, int[] indegree, int[] time, int n){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
          //inarray에서 얼마나 소요 되었는지 확인
            int beforeMaxTime = 0;
            for(int x : inarray.get(now)){
                beforeMaxTime= Math.max(beforeMaxTime,time[x]);
            }
            time[now] = time[now]+ beforeMaxTime;

            for(int next : outarray.get(now)){
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }
        return time[goal];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(TC-->0){
            st = new StringTokenizer(br.readLine());
            int building = Integer.parseInt(st.nextToken());
            int rule = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> outarray = new ArrayList<>();
            ArrayList<ArrayList<Integer>> inarray = new ArrayList<>();

            int[] time = new int[building];
            int[] indegree = new int[building];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<building;i++) {
                time[i] = Integer.parseInt(st.nextToken());
                outarray.add(new ArrayList<>());
                inarray.add(new ArrayList<>());
            }

            for(int i=0;i<rule;i++){
                st = new StringTokenizer(br.readLine());
                int s= Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                outarray.get(s).add(e);
                inarray.get(e).add(s);
                indegree[e]++;
            }
            int goal = Integer.parseInt(br.readLine())-1;
            sb.append(topologicalSort(outarray,inarray,goal,indegree,time,building)).append("\n");
        }
        System.out.println(sb);
    }
}
