package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_23037_5의수난 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long ans = 0;
        for (char c : br.readLine().toCharArray()) {
            ans += Math.pow(Character.digit(c, 10), 5);
        }

        System.out.println(ans);
    }
}
