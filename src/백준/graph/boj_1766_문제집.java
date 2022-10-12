package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1766_문제집 {
    private static StringBuilder sb = new StringBuilder();

    private static void topologicalSort(ArrayList<ArrayList<Integer>> array, int[] indegree,int v){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<v;i++) if(indegree[i]==0) queue.add(i);


        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now+1+" ");

            for(int next : array.get(now)){
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int rule = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();

        int indegree[] = new int[v];
        //Init
        for(int i=0;i<v;i++) array.add(new ArrayList<Integer>());


        for(int i=0;i<rule;i++){
            st = new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            array.get(s).add(e);
            indegree[e]++;
        }

        topologicalSort(array,indegree,v);
        System.out.println(sb);

    }

}
