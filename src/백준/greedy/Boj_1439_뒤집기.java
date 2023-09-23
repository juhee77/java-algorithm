package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int oneCnt = 0;
        int zeroCnt = 0;

        if (s.charAt(0) == '1') {
            oneCnt++;
        } else {
            zeroCnt++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (s.charAt(i) == '1') {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }
        }

        System.out.println(Math.min(oneCnt, zeroCnt));
    }
}
