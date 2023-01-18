package 백준.BFSDFS.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_7576_tomato_bruteforce {

    public static void secondDimensionCpy(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, b[i], 0, a[i].length);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] box = new int[row + 2][col + 2];
        int[][] nextbox = new int[row + 2][col + 2];
        for (int i = 0; i <= row + 1; i++) {
            if (i == 0 || i == row + 1)
                for (int j = 0; j <= col + 1; j++) box[i][j] = -1;
            else {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <= col + 1; j++) {
                    if (j == 0 || j == col + 1) box[i][j] = -1;
                    else box[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //System.out.println(Arrays.toString(box[i]));
        }

        secondDimensionCpy(box, nextbox);
        int day = 0;

        while (day >= 0) {
            int flag = 1;
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < col + 1; j++) {
                    if (box[i][j] == 1) {
                        if (box[i - 1][j] == 0) nextbox[i - 1][j] = 1;
                        if (box[i + 1][j] == 0) nextbox[i + 1][j] = 1;
                        if (box[i][j - 1] == 0) nextbox[i][j - 1] = 1;
                        if (box[i][j + 1] == 0) nextbox[i][j + 1] = 1;
                    } else if (box[i][j] == 0) {
                        if (box[i - 1][j] == -1 && box[i + 1][j] == -1 && box[i][j - 1] == -1 && box[i][j + 1] == -1)
                            day = -1;
                        flag = 0;
                    }
                }
                //System.out.println(Arrays.toString(nextbox[i]));
            }
            if (flag == 1) break;
            secondDimensionCpy(nextbox, box);
            day++;
            //System.out.println(day + '\n');
        }

        System.out.println(day);
    }
}
