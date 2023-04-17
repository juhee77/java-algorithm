package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1652_누을자리를찾아라 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }


        int row = 0, col = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') {
                    cnt++;
                } else {
                    flag = false;
                    cnt = 0;
                }
                if (cnt == 2 && !flag) {
                    row++;
                    flag = true;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == '.') {
                    cnt++;
                } else {
                    flag = false;
                    cnt = 0;
                }
                if (cnt == 2 && !flag) {
                    col++;
                    flag = true;
                }
            }

        }

        System.out.println(row + " " + col);

    }
}
