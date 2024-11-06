package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5597_과제안내신분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] set = new boolean[30];
        for (int i = 0; i < 28; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            set[parseInt - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!set[i]) sb.append(i + 1).append("\n");
        }
        System.out.println(sb);
    }
}
