package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9663_Nqueen2 {
    static int[] arr;
    static boolean[] visit;
    static int size = 0;

    private static void dfs(int n, int m, int d) {
        if (d == m) {
            size++;
//            String temp = "";
//            for (int a : arr) temp += a + 1 + " ";
//            System.out.println(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (d == 0) {
                arr[d] = i;
                visit[i] = true;
                dfs(n, m, d + 1);
                visit[i] = false;
            } else if (!visit[i]) {
                boolean flag = false;
                for (int j = 0; j < d; j++) {
                    if (d - j - 1 < 0 || arr.length <= d - j - 1) continue; //arr의 범위를 넘어가는 경우
                    if (arr[d - j - 1] == i - j - 1 || arr[d - j - 1] == i + j + 1) { //대각선 사선에 있으면 안된다
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                visit[i] = true;
                arr[d] = i;
                dfs(n, m, d + 1);
                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queen = Integer.parseInt(br.readLine());
        arr = new int[queen];
        visit = new boolean[queen];
        dfs(queen, queen, 0);
        System.out.print(size);

    }
}
