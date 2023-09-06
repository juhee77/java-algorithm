package 백준.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int [][] dp = new int[arr1.length+1][arr2.length+1];

        for(int i=1;i<=arr1.length;i++){
            for(int j=1;j<=arr2.length;j++){
                if(arr1[i-1]==arr2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
        int i = arr1.length;
        int j = arr2.length;
        Stack<Character> stack = new Stack<>();
        while(i>=1 && j>=1){
            //위와 같으면 이동
            if(dp[i][j] == dp[i-1][j]) i--;
            //옆와 같으면 이동
            else if(dp[i][j] == dp[i][j-1]) j--;
            else{
                stack.push(arr1[i-1]);
                i--;
                j--;
            }
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop());

    }
}
//string 하면 시간 초과 오류
