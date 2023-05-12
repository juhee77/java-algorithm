package 백준.backTracking.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15651_NM11 {
    private static int n = 0;
    private static int m = 0;
    private static int[] input;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        arr=new int[m];
        //System.out.println(Arrays.toString(input));
        Arrays.sort(input);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int d) {
        if (d == m) {
            for (int e : arr) sb.append(e).append(" ");
            sb.append("\n");

        } else {
            for (int i = 0; i < n; i++) {
                if(arr[d]==input[i])continue;
                arr[d] = input[i];
                dfs(d + 1);
            }
        }
    }
}




