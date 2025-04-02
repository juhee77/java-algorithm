package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17615_볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();

        //R을 앞쪽으로 옮기는 경우
        int rBeforeCnt = 0;
        int rBefore = 0;
        //B를 앞쪽으로 옮기는 경우
        int bBeforeCnt = 0;
        int bBefore = 0;
        for (int i = 0; i < n; i++) {
            if (map[i] == 'R') {
                if (rBefore == -1)
                    rBeforeCnt++;
                bBefore = -1;
            }

            if (map[i] == 'B') {
                if (bBefore == -1)
                    bBeforeCnt++;
                rBefore = -1;
            }
        }

        //R을 뒷쪽으로 옮기는 경우
        int rAfterCnt = 0;
        rBefore = 0;
        //B를 뒷쪽으로 옮기는 경우
        int bAfterCnt = 0;
        bBefore = 0;
        for (int i = n - 1; 0 <= i; i--) {
            if (map[i] == 'R') {
                if (rBefore == -1)
                    rAfterCnt++;
                bBefore = -1;
            }

            if (map[i] == 'B') {
                if (bBefore == -1)
                    bAfterCnt++;
                rBefore = -1;
            }
        }

//        System.out.println("rBeforeCnt = " + rBeforeCnt);
//        System.out.println("rBeforeCnt = " + rAfterCnt);
//        System.out.println("bBeforeCnt = " + bBeforeCnt);
//        System.out.println("bBeforeCnt = " + bAfterCnt);
        System.out.println(Math.min(Math.min(rAfterCnt, rBeforeCnt), Math.min(bAfterCnt, bBeforeCnt)));

    }
}
