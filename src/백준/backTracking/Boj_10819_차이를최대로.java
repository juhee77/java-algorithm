package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10819_차이를최대로 {
    private static int[] arr;
    private static int max = 0;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] =true;
            dfs(1, n, arr[i], 0);
            visited[i]=false;
        }
        System.out.println(max);
    }

    private static void dfs(int nowD, int targetD, int beforeNum, int beforeSum) {
        if (targetD == nowD) {
            max = Math.max(max, beforeSum);
        }else{
            for (int i = 0; i < targetD; i++) {
                if(!visited[i]) {
                    int nowNum = arr[i];
                    visited[i] = true;
                    dfs(nowD + 1, targetD, nowNum, beforeSum + Math.abs(beforeNum - nowNum));
                    visited[i] = false;
                }
            }
        }
    }
}
