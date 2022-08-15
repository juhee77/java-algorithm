package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15829_해싱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        char[] in = br.readLine().toCharArray();
        long ans = 0;
        long pow = 1;

        for (int i = 0; i < input; i++) {
            ans += (pow * ((int) in[i] - 96)) % 1234567891;
            pow = pow * 31 % 1234567891;
        }
        System.out.println(ans % 1234567891);
    }
}
