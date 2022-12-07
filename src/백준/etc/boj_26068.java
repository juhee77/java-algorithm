package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (line-- > 0) {
            int remainDay = Integer.parseInt(br.readLine().substring(2));
            if (remainDay <= 90) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
