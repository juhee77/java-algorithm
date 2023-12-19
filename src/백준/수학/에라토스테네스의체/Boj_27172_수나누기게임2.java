package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_27172_수나누기게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] isContain = new boolean[1_000_001];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            isContain[arr[i]] = true;
        }

        int[] score = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            if (!isContain[temp]) continue;

            for (int j = temp + temp; j <= max; j += temp) {
                if (isContain[j]) {
                    score[temp]++;
                    score[j]--;
                }
            }
        }

        for (int i : arr) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }
}
