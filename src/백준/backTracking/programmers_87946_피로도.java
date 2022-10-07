package 백준.backTracking;

import java.util.Arrays;
import java.util.StringTokenizer;

public class programmers_87946_피로도 {
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int[][] input;
    static boolean[] visit;
    static int cnt = 0;
    static boolean f = false;

    private static void dfs(int d, int k) { //s start d depth
        if (d == arr.length) {
            boolean tempf = true;
//            for (int i = 0; i < d; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();

            for (int i = 0; i < arr.length; i++) {
                if (input[arr[i]][0] <= k) {
                    k -= input[arr[i]][1];
                } else {
                    tempf = false;
                    break;
                }
            }
            if (tempf) f = true;
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visit[i]) {
                visit[i]=true;
                arr[d] = i;
                dfs(d + 1, k);
                if(f)break;

                arr[d] = 0;
                visit[i]=false;
            }
        }

    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        input = dungeons;
        for (int i = dungeons.length; 0 < i; i--) {
            arr = new int[i];
            visit = new boolean[input.length];
            dfs(0, k);
            if (f) return i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new programmers_87946_피로도().solution(80, new int[][]{{60, 20}, {80, 80}, {10, 10}}));


        System.out.println(new programmers_87946_피로도new().solution(30, new int[][]{{60, 20}, {80, 80}, {10, 10}}));
        System.out.println(new programmers_87946_피로도new().solution(80, new int[][]{{60, 20}, {80, 20}, {10, 10}}));
    }
}
