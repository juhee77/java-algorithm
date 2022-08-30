package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10026_적록색약 {
    private static boolean dfs(int arr[][], int x, int y, int goal) {
        if (x >= arr.length || x < 0 || y < 0 || y >= arr[0].length) return false;

        //방문안한 노드이면
        if (arr[x][y] != 0 && arr[x][y] == goal) {
            arr[x][y] = 0;

//            for (int i = 0; i < arr.length; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println();

            dfs(arr, x - 1, y, goal);
            dfs(arr, x + 1, y, goal);
            dfs(arr, x, y - 1, goal);
            dfs(arr, x, y + 1, goal);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int line = Integer.parseInt(br.readLine());

        int arr[][] = new int[line][line];
        int arr2[][] = new int[line][line];

        //입력구간
        for (int i = 0; i < line; i++) {
            String temp = br.readLine();
            for (int j = 0; j < line; j++) {
                char c = temp.charAt(j);
                switch (c) {
                    case 'R':
                        arr[i][j] = arr2[i][j] = 1;
                        break;
                    case 'G':
                        arr[i][j] = 2;
                        arr2[i][j] = 1; // 적록색약은 구분하지 못함
                        break;
                    case 'B':
                        arr[i][j] = arr2[i][j] = 3;
                        break;
                }
            }
        }

        //dfs1
        int cnt = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                if (arr[i][j] != 0)
                    if (dfs(arr, i, j, arr[i][j])) cnt++;
            }
        }

        //dfs2
        int cnt2 = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                if (arr2[i][j] != 0)
                    if (dfs(arr2, i, j, arr2[i][j])) cnt2++;
            }
        }
        System.out.println(cnt + " " + cnt2);

    }
}
