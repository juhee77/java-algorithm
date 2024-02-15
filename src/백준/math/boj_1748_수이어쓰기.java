package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1748_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= numberCount; i *= 10)
            sum += numberCount - i + 1;
        System.out.println(sum);
    }
}
