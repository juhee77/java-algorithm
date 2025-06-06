package 백준.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12847_꿀아르바이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < m; i++)
            sum += arr[i];

        long max = sum;
        int hold = 0;
        for (int i = m; i < n; i++) {
            sum = sum + arr[i] - arr[hold++];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
