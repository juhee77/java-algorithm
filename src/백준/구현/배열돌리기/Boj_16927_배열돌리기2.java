package 백준.구현.배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16927_배열돌리기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArray(map, r);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void rotateArray(int[][] array, int R) {
        int rows = array.length;
        int cols = array[0].length;

        for (int layer = 0; layer < Math.min(rows, cols) / 2; layer++) {
            int rotations = R % (2 * (rows + cols - 4 * layer) - 4);

            for (int r = 0; r < rotations; r++) {
                int temp = array[layer][layer];

                // 위쪽 행
                for (int i = layer; i < cols - 1 - layer; i++) {
                    array[layer][i] = array[layer][i + 1];
                }

                // 오른쪽 열
                for (int i = layer; i < rows - 1 - layer; i++) {
                    array[i][cols - 1 - layer] = array[i + 1][cols - 1 - layer];
                }

                // 아래쪽 행
                for (int i = cols - 1 - layer; i > layer; i--) {
                    array[rows - 1 - layer][i] = array[rows - 1 - layer][i - 1];
                }

                // 왼쪽 열
                for (int i = rows - 1 - layer; i > layer; i--) {
                    array[i][layer] = array[i - 1][layer];
                }

                array[layer + 1][layer] = temp;
            }
        }
    }
}