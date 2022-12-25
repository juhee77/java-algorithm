package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1025_제곱수찾기 {
    private static int row, col;
    private static int[][] map;
    private static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //한 자리
                checkingSquaredAndChangeMax(map[i][j]);
                //모든 경우 확인
                checkMax(i,j);
            }
        }
        System.out.println(max);

    }

    private static void checkMax(int i, int j) {
        int iIdx = -i;
        while(i+iIdx<row) {
            int jIdx = -j;
            while (j + jIdx < col) {
                if(iIdx==0 && jIdx==0) {
                    jIdx++;
                    continue;
                }
                int now = map[i][j];
                int increaseI = i;
                int increaseJ = j;
                while (increaseI + iIdx < row && increaseJ + jIdx < col && 0<=increaseI + iIdx  && 0<=increaseJ + jIdx) {
                    increaseI += iIdx;
                    increaseJ += jIdx;

                    now *= 10;
                    now += map[increaseI][increaseJ];
                    checkingSquaredAndChangeMax(now);
                }
                jIdx++;
            }
            iIdx++;
        }
    }

    private static void checkingSquaredAndChangeMax(int num) {
        if (Math.sqrt(num) % 1 == 0) {
            max = Math.max(num, max);
        }
    }
}
