package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_209222_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int max = 0;
        int[] set = new int[100_001];
        for (int i = 0; i < n; i++) {

            while (set[arr[i]] >= k) {
                set[arr[left++]]--;
            }

            set[arr[i]]++;

            max = Math.max(max, i - left + 1);
        }
        System.out.println(max);
    }
}
