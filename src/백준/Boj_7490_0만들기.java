package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_7490_0만들기 {
    static int N;
    static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            N = Integer.parseInt(br.readLine());
            result = new ArrayList<>();
            dfs(1, "1");

            Collections.sort(result);
            for (String expr : result) {
                sb.append(expr).append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int num, String expr) {
        if (num == N) {
            if (evaluation(expr) == 0) {
                result.add(expr);
            }
            return;
        }

        int nextNum = num + 1;
        dfs(nextNum, expr + " " + nextNum); // 공백(연결)
        dfs(nextNum, expr + "+" + nextNum); // 더하기
        dfs(nextNum, expr + "-" + nextNum); // 빼기
    }

    private static int evaluation(String expr) {
        expr = expr.replace(" ", "");
        int sum = 0, num = 0;
        char sign = '+';

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) || i == expr.length() - 1) {
                if (sign == '+') sum += num;
                else sum -= num;
                sign = ch;
                num = 0;
            }
        }
        return sum;
    }
}
