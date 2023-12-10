package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_22869_징검다리건너기 {
    private static int[] arr;
    private static int n, power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        power = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                for (int j = i + 1; j < n; j++) {
                    int po = (j - i) * (1 + Math.abs(arr[i] - arr[j]));
                    if (po < power) {
                        visited[j] = true;
                    }
                }
            }
        }
        System.out.println(visited[n - 1] ? "YES" : "NO");
    }
}
