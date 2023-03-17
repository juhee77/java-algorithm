package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16637_괄호추가하기 {
    private static int n;
    private static char[] all;
    private static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //괄호는 숫자 앞에 들어가고 열렸으면 닫아야 한다.
        n = Integer.parseInt(br.readLine());
        all = br.readLine().toCharArray();

        //dfs
        findAll(1, getNowNum(all[0]), "");
        System.out.println(max);
    }

    private static int getNowNum(char c) {
        return c-'0';
    }

    private static void findAll(int nowD, long nowSum, String now) {
        if (nowD == n) {
            if (now.length() > 1) {
                int n = now.charAt(1) - '0';
                if (now.charAt(0) == '*') nowSum *= n;
                else if (now.charAt(0) == '+') nowSum += n;
                else nowSum -= n;
            }

            max = Math.max(max, nowSum);
            return;
        }
        //만약 연산 기호이면 그냥 now넣어서 지나간다.
        if (nowD % 2 == 1) {
            findAll(nowD + 1, nowSum, now + all[nowD]);
        } else {
            //[계산하거나 추가하거나]
            //계산
            findAll(nowD + 1, calculate(nowSum, (now + all[nowD]).toCharArray()), "");
            //추가
            if(now.length()<3)findAll(nowD + 1, nowSum, now + all[nowD]);

        }
    }

    private static long calculate(long preSum, char[] formula) {
        long ans;

        if (formula.length >= 3) {
            int a1 = getNowNum(formula[1]);
            int a2 = getNowNum(formula[3]);
            if (formula[2] == '*') ans = (long) a1 * a2;
            else if (formula[2] == '+') ans = a1 + a2;
            else ans = a1 - a2;
        } else {
            ans = getNowNum(formula[1]);
        }

        if (formula[0] == '*') ans = preSum * ans;
        else if (formula[0] == '+') ans = preSum + ans;
        else ans = preSum - ans;

        return ans;
    }
}
