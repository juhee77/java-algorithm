package 프로그래머스.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_147355_크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;

        int pLength = p.length();
        long pNum = Long.parseLong(p);

        for (int i = 0; i < t.length() - pLength + 1; i++) {
            String temp = t.substring(i, i + pLength);
            // System.out.println(temp);
            long tempN = Long.parseLong(temp);
            if (tempN <= pNum) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Programmers_147355_크기가작은부분문자열 solution = new Programmers_147355_크기가작은부분문자열();
//        System.out.println(solution.solution(br.readLine(), br.readLine()));
        System.out.println(solution.solution("500220839878", "7"));
    }
}
