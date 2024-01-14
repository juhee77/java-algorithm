package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_27433_팩토리얼2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long ans = 1;
        for (int j = 2; j <= n; j++) {
            ans *= j;
        }
        System.out.println(ans);
    }
}
