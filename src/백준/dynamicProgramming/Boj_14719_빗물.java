package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[w + 1];
        for (int i = w - 1; 0 <= i; i--) {
            leftMax[i] = Math.max(leftMax[i + 1], arr[i]);
        }
        int rightMax = arr[0];
        int ans = 0;
        for (int i = 1; i < w; i++) {
            rightMax = Math.max(rightMax, arr[i - 1]);
            ans += Math.max(0, Math.min(rightMax, leftMax[i]) - arr[i]);
        }
        System.out.println(ans);
    }
}
