package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj_32172_현권이와신기한수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> already = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int now = 0, before = 0;

        for (int i = 1; i <= n; i++) {
            int next = before - i;
            if (next <= 0 || already.contains(next)) {
                now = before + i;
            } else {
                now = next;
            }
//            System.out.println(now);
            already.add(now);
            before = now;
        }
        System.out.println(before);
    }
}
