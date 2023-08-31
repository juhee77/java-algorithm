package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14916_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = -1;
        for (int i = (n / 5) + 1; 0 <= i; i--) {
            int remain = n - (5 * i);
            if ((0 <= remain) && remain % 2 == 0) {
                ans = i + (remain / 2);
                break;
            }
        }
        System.out.println(ans);
    }
}