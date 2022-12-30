package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16916_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] find = br.readLine().toCharArray();

        System.out.println(findWord(str, find));
    }

    private static int findWord(char[] str, char[] find) {
        int[] dp = new int[str.length+1];
        for(int i=1;i<=find.length;i++){
            for(int j=str.length;0<j;j--){
                if(find[i-1] == str[j-1]){
                    dp[j] = dp[j-1]+1;
                    if(dp[j]==find.length) return 1;
                }
            }

        }
        return 0;
    }
}
