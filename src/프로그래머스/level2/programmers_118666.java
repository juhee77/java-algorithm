package 프로그래머스.level2;

public class programmers_118666 {
    public String solution(String[] survey, int[] choices) {
        int ans[][] = new int[4][2];
        for (int i = 0; i < survey.length; i++) {
            if (4 < choices[i]) {
                count((choices[i] % 4), ans, survey[i].charAt(1));
            } else if (choices[i] < 4) {
                count(4 - choices[i], ans, survey[i].charAt(0));
            }

        }
        String answer = "";
        answer += (ans[0][0] >= ans[0][1]) ? "R" : "T";
        answer += (ans[1][0] >= ans[1][1]) ? "C" : "F";
        answer += (ans[2][0] >= ans[2][1]) ? "J" : "M";
        answer += (ans[3][0] >= ans[3][1]) ? "A" : "N";

        return answer;
    }

    private static void count(int point, int ans[][], char s) {
        switch (s) {
            case 'R':
                ans[0][0] += point;
                break;
            case 'T':
                ans[0][1] += point;
                break;
            case 'C':
                ans[1][0] += point;
                break;
            case 'F':
                ans[1][1] += point;
                break;

            case 'J':
                ans[2][0] += point;
                break;
            case 'M':
                ans[2][1] += point;
                break;

            case 'A':
                ans[3][0] += point;
                break;
            case 'N':
                ans[3][1] += point;
                break;
        }
    }

}
