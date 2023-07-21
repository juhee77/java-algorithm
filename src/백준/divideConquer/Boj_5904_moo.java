package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5904_moo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //몇 길이의 수열이 필요한가.
        int k = 3;
        int now = 0;
        while (k < n) {
            now++;
            k = k * 2 + (3 + now);
        }

        int ans = dfs(now, k, n);
        if (ans == 1) {
            System.out.println('m');
        } else System.out.println('o');
    }

    private static int dfs(int depth, int length, int find) {
        int leftSize = (length - (depth + 3)) / 2;
        if (leftSize < find) {
            find -= leftSize;

            if (find <= (depth + 3)) {
                return find;
            }
            find -= depth + 3;
        }


        return dfs(depth - 1, length - leftSize - (depth + 3), find); //왼쪽에서 찾는다.
    }

}
