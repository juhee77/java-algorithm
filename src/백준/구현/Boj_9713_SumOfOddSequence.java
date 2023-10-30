package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9713_SumOfOddSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int a = (Integer.parseInt(br.readLine()) + 1) / 2;
            sb.append((int) Math.pow(a, 2)).append("\n");

        }
        System.out.println(sb);
    }
}
