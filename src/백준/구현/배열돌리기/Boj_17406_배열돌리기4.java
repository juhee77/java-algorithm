package 백준.구현.배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17406_배열돌리기4 {
    private static boolean[] visited;
    private static int[][] rotations;
    private static int[] cur;
    private static int n, k, m;
    private static int[][] arr;


    private static int sumMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotations = new int[k][3];
        for (int rotation = 0; rotation < k; rotation++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            rotations[rotation][0] = r;
            rotations[rotation][1] = c;
            rotations[rotation][2] = s;
        }

        visited = new boolean[k];
        cur = new int[k];
        dfs(0, k);
        System.out.println(sumMin);

    }

    private static void dfs(int nDepth, int goal) {
        if (nDepth == goal) {
            int[][] temp = arrayClone(arr);
            for (int i : cur)
                temp = getRotated(temp, rotations[i]);

            for (int i = 0; i < temp.length; i++) {
                int tempSum = 0;
                for (int anInt : temp[i]) {
                    tempSum += anInt;
                }
                sumMin = Math.min(tempSum, sumMin);
            }
            return;
        }

        for (int i = 0; i < goal; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur[nDepth] = i;
                dfs(nDepth + 1, goal);
                visited[i] = false;
            }
        }
    }

    private static int[][] arrayClone(int[][] arr) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++)
            temp[i] = arr[i].clone();
        return temp;
    }

    private static int[][] getRotated(int[][] original, int[] rotation) {
        int r = rotation[0];
        int c = rotation[1];
        int s = rotation[2];
        int[][] temp = arrayClone(original);

        for (int i = s; 0 < i; i--) {
            //위
            for (int x = c - i + 1; x <= c + i; x++) {
                temp[r - i][x] = original[r - i][x - 1];
            }

            //오
            for (int x = r - i + 1; x <= r + i; x++) {
                temp[x][c + i] = original[x - 1][c + i];
            }

            //아
            for (int x = c + i - 1; c - i <= x; x--) {
                temp[r + i][x] = original[r + i][x + 1];
            }

            //왼
            for (int x = r + i - 1; r - i <= x; x--) {
                temp[x][c - i] = original[x + 1][c - i];
            }
        }
        return temp;
    }
}
