package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2661_좋은수열 {
    private static int goalLen;
    private static String ans = "";
    private static char[] str;

    //길이가 N인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //가능한 모든 수열에 대해서
        goalLen = Integer.parseInt(br.readLine());
        str = new char[goalLen];
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int nowDepth) {
        if (!ans.equals("")) return;

        if (nowDepth == goalLen) {
            ans = new String(str);
            return;
        }

        for (char i = '1'; i <= '3'; i++) {
            if (nowDepth > 0 && str[nowDepth - 1] == i) { //같은 숫자
                continue;
            }

            str[nowDepth] = i;
            boolean flag = true;
            for (int j = 0; j < nowDepth / 2; j++) {
                for (int p = 0; p < j; p++) {
                    if (str[nowDepth - p] == str[nowDepth - j - p]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (!flag) continue;

            //nowDepth 이전까지의 모든 idx를 기준으로 겹치지 않아야 한다.
            dfs(nowDepth + 1);
        }
    }
}
