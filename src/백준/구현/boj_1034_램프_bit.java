package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 초과
 */
public class boj_1034_램프_bit {
    private static char[][] lamps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        lamps = new char[row][col];

        for (int i = 0; i < row; i++) {
            lamps[i] = br.readLine().toCharArray();
        }
        int chance = Integer.parseInt(br.readLine());


        System.out.println(getMaxLitRows(chance));
    }

    public static int getMaxLitRows(int K) {
        int numRows = lamps.length;
        int numCols = lamps[0].length;
        int maxLitRows = 0;

        for (int i = 0; i < (1 << numRows); i++) {
            int numSwitches = Integer.bitCount(i);
            if (numSwitches <= K) {
                int[][] tempLamps = new int[numRows][numCols];
                for (int j = 0; j < numRows; j++) {
                    if ((i & (1 << j)) != 0) {
                        for (int k = 0; k < numCols; k++) {
                            tempLamps[j][k] = 1 - lamps[j][k];
                        }
                    } else {
                        for (int k = 0; k < numCols; k++) {
                            tempLamps[j][k] = lamps[j][k];
                        }
                    }
                }
                int numLitRows = countLitRows(tempLamps);
                maxLitRows = Math.max(maxLitRows, numLitRows);
            }
        }

        return maxLitRows;
    }

    public static int countLitRows(int[][] lamps) {
        int numLitRows = 0;
        for (int[] row : lamps) {
            boolean isLitRow = true;
            for (int lamp : row) {
                if (lamp == 0) {
                    isLitRow = false;
                    break;
                }
            }
            if (isLitRow) {
                numLitRows++;
            }
        }
        return numLitRows;
    }
}
