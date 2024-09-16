package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17214_다항함수의적분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        String input = br.readLine().replace("-", "+-");
        String[] terms = input.split("[+]");

        for (String term : terms) {
            int xCnt = 0;
            char[] eachTerm = term.toCharArray();
            for (char c : eachTerm) {
                if (c == 'x') {
                    xCnt++;
                }
            }

            if (term.length() > 0) {
                int prefix = 0;
                int xPlace = term.indexOf('x');
                String prefixNumber;

                if (eachTerm[0] == '-') {
                    if ((ans.length() != 0)) ans.delete(ans.length() - 1, ans.length());
                    prefixNumber = xPlace != -1 ? term.substring(1, xPlace) : term.substring(1);
                    if (prefixNumber.length() > 0) prefix = Integer.parseInt(prefixNumber);
                    ans.append("-");
                } else {
                    prefixNumber = xPlace != -1 ? term.substring(0, xPlace) : term;
                    if (prefixNumber.length() > 0) prefix = Integer.parseInt(prefixNumber);
                }

                int coefficient = (prefix == 0) ? 0 : prefix / (xCnt + 1);
                if (coefficient >= 1) {
                    if (coefficient != 1) ans.append(coefficient);
                    ans.append("x".repeat(xCnt + 1));
                    ans.append("+");
                }
            }
        }
        ans.append("W");
        System.out.println(ans);
    }
}
