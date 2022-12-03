package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int total = 64;
        int cnt = 1;

        while (0 < X) {
            if (total > X) {
                total = total >> 1;
                if (total < X) {
                    X -= total;
                    cnt++;
                }
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}
