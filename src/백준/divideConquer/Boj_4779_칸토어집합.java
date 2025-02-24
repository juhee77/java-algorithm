package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_4779_칸토어집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;

            int n = Integer.parseInt(s);
            sb.append(getCanTore(0, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static String getCanTore(int i, int n) {
        if (n == 0) return "-";
        if (i == n) return "";

        StringBuilder sb = new StringBuilder();
        //왼
        String saved = getCanTore(i, n - 1);
        sb.append(saved);

        //중간
        sb.append(" ".repeat((int) Math.pow(3, n - 1)));

        //오
        sb.append(saved);
        return sb.toString();
    }
}
