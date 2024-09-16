package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17214_다항함수의적분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        input = input.replace("-", "+-");
//        System.out.println(input);
        String[] arr = input.split("[+]");

        for (String s : arr) {
//            System.out.println(s);
            int xCnt = 0;
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if (c == 'x') {
                    xCnt++;
                }
            }

            if (s.equals("")) continue;

            int prefix = 0;
            int xPlace = s.indexOf('x');
            if (charArray[0] == '-') {
                sb = (sb.length() != 0) ? sb.delete(sb.length() - 1, sb.length()) : sb;
                String substring = xPlace != -1 ? s.substring(1, xPlace) : s.substring(1);
//                System.out.println(substring);
                if (substring.length() > 0) prefix = Integer.parseInt(substring);

                sb.append("-");
            } else {
                String substring = xPlace != -1 ? s.substring(0, xPlace) : s;
//                System.out.println(substring);

                if (substring.length() > 0) prefix = Integer.parseInt(substring);
            }
            int i = (prefix == 0) ? 0 : prefix / (xCnt + 1);
//            System.out.println("I" + " " + i);
            if (i != 1) sb.append(i);
            sb.append("x".repeat(xCnt + 1));
            sb.append("+");
        }
        sb.append("W");
        System.out.println(sb);
    }
}
