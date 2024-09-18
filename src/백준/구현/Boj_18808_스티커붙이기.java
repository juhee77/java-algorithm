package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18808_스티커붙이기 {
    private static int row, col;
    private static boolean[][] board;
    private static boolean[][] sticker;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int sCnt = Integer.parseInt(st.nextToken());
        board = new boolean[row][col];

        for (int s = 0; s < sCnt; s++) {
            st = new StringTokenizer(br.readLine());
            int sRow = Integer.parseInt(st.nextToken());
            int sCol = Integer.parseInt(st.nextToken());

            sticker = new boolean[sRow][sCol];
            for (int x = 0; x < sRow; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < sCol; y++) {
                    sticker[x][y] = Integer.parseInt(st.nextToken()) == 1;
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                if (findAbleLocation())
                    break;
                //rotation
                sticker = getRotatedSticker();
            }
        }

        int filled = 0;
        for (int i = 0; i < row; i++) {
            for (boolean b : board[i]) {
                if (b) filled++;
            }
        }
        System.out.println(filled);
    }

    private static boolean[][] getRotatedSticker() {
        boolean[][] tempSticker = new boolean[sticker[0].length][sticker.length];
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                tempSticker[j][sticker.length - 1 - i] = sticker[i][j];
            }
        }
        return tempSticker;
    }

    private static boolean findAbleLocation() {
        for (int i = 0; i <= row - sticker.length; i++) {
            for (int j = 0; j <= col - sticker[0].length; j++) {
                if (checkIsAble(i, j)) {
                    //붙이기
                    for (int p = i; p < i + sticker.length; p++) {
                        for (int q = j; q < j + sticker[0].length; q++) {
                            if (sticker[p - i][q - j] && !board[p][q]) {
                                board[p][q] = true;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkIsAble(int x, int y) {
        for (int i = x; i < x + sticker.length; i++) {
            for (int j = y; j < y + sticker[0].length; j++) {
                if (sticker[i - x][j - y] && board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
