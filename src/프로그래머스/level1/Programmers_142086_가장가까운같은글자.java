package 프로그래머스.level1;

import java.io.IOException;
import java.util.Arrays;

public class Programmers_142086_가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] charIndex = new int[26];
        Arrays.fill(charIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            answer[i] = (charIndex[temp] == -1) ? -1 : i - charIndex[temp];
            charIndex[temp] = i;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Programmers_142086_가장가까운같은글자 programmers142086_가장가까운같은글자 = new Programmers_142086_가장가까운같은글자();
        System.out.println(Arrays.toString(programmers142086_가장가까운같은글자.solution("banana")));
    }
}
