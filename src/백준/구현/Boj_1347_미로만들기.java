package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1347_미로만들기 {
    private static final int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[100][100];

        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int row = 49, col = 49;
        int dir = 0;
        int maxRow = 49, maxCol = 49;
        int minRow = 49, minCol = 49;

        arr[row][col] = 1;
        for (char c : input) {
            switch (c) {
                case 'L':
                    dir--;
                    break;
                case 'R':
                    dir++;
                    break;
                case 'F':
                    dir = (dir + 52) % 4;
                    row = (row) + dirs[dir][0];
                    col = (col) + dirs[dir][1];
                    maxRow = Math.max(row, maxRow);
                    minRow = Math.min(row, minRow);
                    maxCol = Math.max(col, maxCol);
                    minCol = Math.min(col, minCol);
                    arr[row][col] = 1;
                    break;
                default:
                    break;
            }
        }


        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                sb.append(arr[i][j] == 1 ? "." : "#");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
