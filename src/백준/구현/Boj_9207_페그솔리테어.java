package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9207_페그솔리테어 {
    private static char[][] board = new char[5][9];
    private static int minPin, minTurn;

    private static final int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0} // 오른쪽, 왼쪽, 아래, 위
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            minPin = 8;
            minTurn = Integer.MAX_VALUE;

            int pinCount = 0; // 핀 개수 카운트
            for (int i = 0; i < 5; i++) {
                board[i] = br.readLine().toCharArray();
                for (char c : board[i]) {
                    if (c == 'o') pinCount++;
                }
            }

            solve(pinCount, 0);
            sb.append(minPin).append(" ").append(minTurn).append("\n");

            if (tc > 0) br.readLine();
        }
        System.out.println(sb);
    }

    private static void solve(int pinCount, int turn) {
        boolean canMove = false;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != 'o') continue;

                for (int[] d : directions) {
                    int nx = x + d[0], ny = y + d[1];
                    int nnx = x + 2 * d[0], nny = y + 2 * d[1];

                    if (isValidMove(nx, ny, nnx, nny)) {
                        board[x][y] = '.';
                        board[nx][ny] = '.';
                        board[nnx][nny] = 'o';

                        solve(pinCount - 1, turn + 1);

                        board[x][y] = 'o';
                        board[nx][ny] = 'o';
                        board[nnx][nny] = '.';
                        canMove = true;
                    }
                }
            }
        }

        if (!canMove) {
            if (pinCount < minPin) {
                minPin = pinCount;
                minTurn = turn;
            } else if (pinCount == minPin) {
                minTurn = Math.min(minTurn, turn);
            }
        }
    }

    private static boolean isValidMove(int nx, int ny, int nnx, int nny) {
        return (nx >= 0 && nx < 5 && ny >= 0 && ny < 9 &&
                nnx >= 0 && nnx < 5 && nny >= 0 && nny < 9 &&
                board[nx][ny] == 'o' && board[nnx][nny] == '.');
    }
}
