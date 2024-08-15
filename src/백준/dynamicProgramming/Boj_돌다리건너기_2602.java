package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_돌다리건너기_2602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();
        int[][][] ans = new int[2][2][word.length + 1];
        char[] devil = br.readLine().toCharArray();
        char[] angel = br.readLine().toCharArray();
        ans[0][0][0] = ans[0][1][0] = ans[1][0][0] = ans[1][1][0] = 1;

        int now = 0;
        for (int i = 0; i < devil.length; i++) {
            int next = (now + 1) % 2;
            for (int j = 1; j <= word.length; j++) {
                ans[next][0][j] = ans[now][0][j];
                if (devil[i] == word[j - 1]) {
                    ans[next][0][j] += ans[now][1][j - 1];
                }

                ans[next][1][j] = ans[now][1][j];
                if (angel[i] == word[j - 1]) {
                    ans[next][1][j] += ans[now][0][j - 1];
                }
            }
            now = (now + 1) % 2;
        }
        System.out.println(ans[now][0][word.length] + ans[now][1][word.length]);
    }
}
