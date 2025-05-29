package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2846_오르막길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int before = arr[0];
        int nowIdx = 0;
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            int now = arr[i];
            if (before >= now) {
                maxLen = Math.max(maxLen, arr[i - 1] - arr[nowIdx]);
                nowIdx = i;
            }
            before = now;
        }

        maxLen = Math.max(maxLen, arr[n - 1] - arr[nowIdx]);
        System.out.println(maxLen);
    }
}
