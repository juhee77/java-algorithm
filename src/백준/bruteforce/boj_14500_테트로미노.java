package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14500_테트로미노 {
    private static int find(int arr[][], int[] dirx, int[] diry) {
        int max = 0;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = 0;
                boolean found = true;
                for (int n = 0; n < 4 && found; n++) {
                    int tempx = i + dirx[n];
                    int tempy = j + diry[n];
                    if (tempx >= row || tempy >= col) {
                        found = false; //범위를 넘어가면 생략
                        break;
                    }
                    temp += arr[tempx][tempy];
                }
                if (found) max = Math.max(max, temp);
            }
        }
        //System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int arr[][] = new int[row][col]; //기본

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //직사각형
        int r1 = find(arr, new int[]{0, 1, 2, 3}, new int[]{0, 0, 0, 0});
        int r2 = find(arr, new int[]{0, 0, 0, 0}, new int[]{0, 1, 2, 3});
        int ans = Math.max(r1, r2);
        //정사각형
        r1 = find(arr, new int[]{0, 0, 1, 1}, new int[]{0, 1, 0, 1});
        ans = Math.max(r1, ans);
        //L
        ans = Math.max(find(arr, new int[]{0, 1, 2, 2}, new int[]{0, 0, 0, 1}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 2, 2}, new int[]{1, 1, 1, 0}), ans);
        ans = Math.max(find(arr, new int[]{0, 0, 1, 2}, new int[]{0, 1, 0, 0}), ans);
        ans = Math.max(find(arr, new int[]{0, 0, 1, 2}, new int[]{0, 1, 1, 1}), ans);

        ans = Math.max(find(arr, new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 2}), ans);
        ans = Math.max(find(arr, new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 0}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 1}, new int[]{2, 0, 1, 2}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 1}, new int[]{0, 0, 1, 2}), ans);

        //ㄱㄴ
        ans = Math.max(find(arr, new int[]{0, 0, 1, 1}, new int[]{0, 1, 1, 2}), ans);
        ans = Math.max(find(arr, new int[]{0, 0, 1, 1}, new int[]{1, 2, 0, 1}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 2}, new int[]{1, 0, 1, 0}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 2}, new int[]{0, 0, 1, 1}), ans);

        //ㅜ
        ans = Math.max(find(arr, new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 1}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 2}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 2}, new int[]{0, 0, 1, 0}), ans);
        ans = Math.max(find(arr, new int[]{0, 1, 1, 2}, new int[]{1, 0, 1, 1}), ans);

        System.out.println(ans);

    }
}
