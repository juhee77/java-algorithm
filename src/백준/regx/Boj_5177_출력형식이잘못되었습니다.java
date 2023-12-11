package 백준.regx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5177_출력형식이잘못되었습니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            String input2 = br.readLine();

            String result1 = refactorString(input.strip().toLowerCase());
            String result2 = refactorString(input2.strip().toLowerCase());


            if (result1.equals(result2)) {
                sb.append("Data Set " + i + ": equal");
            } else {
                sb.append("Data Set " + i + ": not equal");
            }
            sb.append("\n\n");
        }
        System.out.println(sb);
    }

    public static String refactorString(String input) {
        input = input.replaceAll("[\\[\\{]", "(");
        input = input.replaceAll("[\\]\\}]", ")");

        input = input.replaceAll(",", ";");

        input = input.replaceAll("(\\s)\\1+", "$1");

        input = input.replaceAll("\\s*(\\(|\\)|\\[|\\]|\\{|\\}|\\.|\\,|\\;|\\:)\\s*", "$1");

        return input;
    }
}
