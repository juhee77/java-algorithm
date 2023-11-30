package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2216_문자열과정수 {
    public static final int INF = -10000000;
    private static int[][] dp;
    private static char[] c1;
    private static char[] c2;
    private static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        c1 = br.readLine().toCharArray();
        c2 = br.readLine().toCharArray();
        dp = new int[c1.length][c2.length];

        //공백으로 가는 경우
        //같은 경우
        for (int i = 0; i < c1.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(findAns(0, 0));
    }

    private static int findAns(int left, int right) {
        if (left == c1.length && right == c2.length) {
            return 0;
        } else if (left == c1.length && right < c2.length) {
            return b * (c2.length - right);
        } else if (left < c1.length && right == c2.length) {
            return b * (c1.length - left);
        }

        if (dp[left][right] != INF) {
            return dp[left][right];
        }

        int temp = INF;
        if (c1[left] == c2[right]) {
            temp = Math.max(temp, findAns(left + 1, right + 1) + a);
        } else {
            temp = Math.max(temp, findAns(left + 1, right + 1) + c);
        }
        temp = Math.max(temp, b + findAns(left + 1, right));
        temp = Math.max(temp, b + findAns(left, right + 1));


        return dp[left][right] = temp;
    }


}
