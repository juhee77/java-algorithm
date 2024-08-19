package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_13909_창문닫기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int windows = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i * i <= windows; i++) {
            ans++;
        }

        System.out.println(ans);
    }
}
