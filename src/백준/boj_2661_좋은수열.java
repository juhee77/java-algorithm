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
        if (!ans.equals("")) return; //이미 발견함

        if (nowDepth == goalLen) { //발견했다.
            ans = new String(str);
            return;
        }

        for (char i = '1'; i <= '3'; i++) {
            str[nowDepth] = i;
            boolean flag = true; //우선 넣고 가능한지 확인한다.

            for (int j = 1; j <= (nowDepth + 1) / 2; j++) {
                //돌아가면서 확인한다. 4배열이라면 [4,3비교] [4,2비교 - 1,3 비교]와 같이 모든 경우 확인
                flag = false;
                for (int p = 1; p < (j + 1); p++) {
                    if (str[nowDepth - p + 1] != str[nowDepth - j - p + 1]) {
                        flag = true; // 같지 않다 -> 괜찮다.(좋은 수열이다)
                        break;
                    }
                }

                if(!flag) break; //괜찮지 않다면(다 똑같다면)-> 나쁜 수열
            }
            if (!flag) continue;//나쁜 수열이라면 다음숫자 확인

            //가능한 경우에만 다음것으로 확인
            dfs(nowDepth + 1);
        }
    }
}
