package 백준.graph;
import java.io.*;
import java.util.StringTokenizer;

public class Boj_17199_MilkFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] outgoing = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            outgoing[a]++;
        }

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (outgoing[i] == 0 && answer != -1) {
                answer = -1; // 두 개의 싱크를 찾음 - 오류
                break;
            }
            if (outgoing[i] == 0) {
                answer = i; // 첫 번째 싱크를 찾음 기억함
            }
        }

        writer.write(answer + "\n");
        writer.close();
    }
}