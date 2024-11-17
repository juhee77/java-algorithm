package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1855_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int col = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int row = s.length / col;
        char[][] map = new char[row][col];
        int hold = 0;

        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < col && hold < s.length; j++) {
                    map[i][j] = s[hold++];
                }
            } else {
                for (int j = col - 1; 0 <= j && hold < s.length; j--) {
                    map[i][j] = s[hold++];
                }
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                sb.append(map[j][i]);
            }
        }
        System.out.println(sb);
    }
}
