package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1080_행렬 {
    private static int row, col;
    private static char[][] map;
    private static char[][] goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        goal = new char[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < row; i++) {
            goal[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (map[i - 1][j - 1] != goal[i - 1][j - 1]) { //제인 왼쪽 상단 부터 맞춰간다.
                    cnt++;
                    reverse(i, j);
                }

//                for (int p = 0; p < row; p++) {
//                    System.out.println(Arrays.toString(map[p]));
//                }
//                System.out.println();
            }
        }
        if (checkWithTargetMatrix()) System.out.println(cnt);
        else System.out.println(-1);
    }

    private static boolean checkWithTargetMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != goal[i][j]) return false;
            }
        }
        return true;
    }

    private static void reverse(int i, int j) {
        for (int p = i - 1; p < i + 2; p++) {
            for (int q = j - 1; q <= j + 1; q++) {
                if (map[p][q] == '1') map[p][q] = '0';
                else map[p][q] = '1';
            }
        }
    }

}
