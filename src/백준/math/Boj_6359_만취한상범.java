package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_6359_만취한상범 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[num + 1];
            //t : 닫힌거, f: 열린것
            for (int i = 2; i <= num; i++) {
                for (int j = i; j <= num; j = j + i) {
                    arr[j] = !arr[j];
                }
            }

            int ans = -1;
            for (boolean b : arr) {
                if (!b) ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
