package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_14002_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int sz = Integer.parseInt(br.readLine());
        int[] dp = new int[sz];
        int[] arr = new int[sz];
        int totalMaxLen = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<sz;i++){
            int maxLength=0;
            int now =  Integer.parseInt(st.nextToken());
            arr[i] = now;

            for(int j=0;j<i;j++){
                if(arr[j]<now) {
                    maxLength = Math.max(dp[j],maxLength);
                }
            }
            dp[i]=maxLength+1; //자기 포함
            totalMaxLen = Math.max(totalMaxLen,dp[i]);
        }

        Stack<Integer> stack = new Stack<>();
        sb.append(totalMaxLen).append('\n');
        for(int i=sz-1;0<=i;i--){
            if(dp[i]==totalMaxLen){
                stack.add(arr[i]);
                totalMaxLen--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
}
