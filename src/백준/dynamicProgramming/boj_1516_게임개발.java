package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1516_게임개발 {
    private static final StringBuilder sb = new StringBuilder();
    private static final ArrayList<ArrayList<Integer>> inGraph = new ArrayList<>();
    private static final ArrayList<ArrayList<Integer>> outGraph = new ArrayList<>();
    private static int[] dp;
    private static int[] inDegree;
    private static int[] spendTime;

    private static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i< dp.length; i++){
            if(inDegree[i]==0){
                dp[i] = spendTime[i];
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next: outGraph.get(now)){
                inDegree[next]--;
                if(inDegree[next]==0) {
                    int maxT=0;
                    for(int previous : inGraph.get(next)){
                        maxT =Math.max(maxT,dp[previous]+spendTime[next]);
                    }
                    dp[next] = Math.min(dp[next],maxT);
                    queue.add(next);
                }
            }
        }

        for(int e:dp){
            sb.append(e).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int size = Integer.parseInt(br.readLine());
        dp = new int[size];
        spendTime=new int[size];
        inDegree =new int[size];
        Arrays.fill(dp,50000001);

        for(int i=0;i<size;i++){
            inGraph.add(new ArrayList<>());
            outGraph.add(new ArrayList<>());
        }

        for(int i=0;i<size;i++){
            st = new StringTokenizer(br.readLine());

            spendTime[i]= Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int beforeBuilt = Integer.parseInt(st.nextToken())-1;
                if(beforeBuilt==-2)break;
                outGraph.get(beforeBuilt).add(i);
                inGraph.get(i).add(beforeBuilt);
                inDegree[i]++;
            }
        }

        topologySort();
        System.out.println(sb);
    }
}
