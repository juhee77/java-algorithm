package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16987_계란으로계란치기 {
    private static int[][] eggs;
    private static int n;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken()); //내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); //무게
        }

        backtracking(0, 0);
        System.out.println(max);
    }

    private static void backtracking(int nowEggIndex, int breakEgg) {
        if (nowEggIndex == n) { //마지막 계란이 깨져있거나, 마지막 계란까지 계산 완료
            max = Math.max(breakEgg, max);
            return;
        }
        if (breakEgg == n - 1 || eggs[nowEggIndex][0] <= 0) {
            backtracking(nowEggIndex + 1, breakEgg);
            return;
        }

        int[] nowEgg = eggs[nowEggIndex];


        for (int i = 0; i < n; i++) {
            if (eggs[i][0] <= 0 || i == nowEggIndex) continue;

            nowEgg[0] -= eggs[i][1];
            eggs[i][0] -= nowEgg[1];

            int tmpBreakEgg = 0;
            if (nowEgg[0] <= 0) {
                tmpBreakEgg++;
            }
            if (eggs[i][0] <= 0) {
                tmpBreakEgg++;
            }

            backtracking(nowEggIndex + 1, breakEgg + tmpBreakEgg);
            nowEgg[0] += eggs[i][1];
            eggs[i][0] += nowEgg[1];
        }
    }
}
