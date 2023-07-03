package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2503_숫자야구2 {
    private static int[] ans = new int[3];
    private static String[] arr;
    private static int[][] cmds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ableCnt = 0;
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        cmds = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            cmds[i][0] = Integer.parseInt(st.nextToken());
            cmds[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 10; i++) {
            ans[0] = i;
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                ans[1] = j;
                for (int k = 1; k < 10; k++) {
                    if (i == k || j == k) continue;
                    ans[2] = k;
                    if (checkAble()) {
                        ableCnt++;
                    }
                }
            }
        }

        System.out.println(ableCnt);
    }


    private static boolean checkAble() {
        for (int i = 0; i < cmds.length; i++) {
            int ball = 0;
            int strike = 0;

            //ball
            for (int p = 0; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    if (ans[p] + '0' == arr[i].charAt(q)) {
                        if (p == q) strike++;
                        else ball++;
                    }
                }
            }

            if (cmds[i][0] != strike || cmds[i][1] != ball) {
                return false;
            }
        }
        return true;
    }
}
