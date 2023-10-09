package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2800_괄호제거 {
    private static final List<int[]> allPair = new ArrayList<>();
    private static final Set<String> allAnswers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> indexes = new Stack<>();
        String input = br.readLine();
        char[] chars = input.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                indexes.add(i);
            } else if (chars[i] == ')') {
                allPair.add(new int[]{indexes.pop(), i});
            }
        }

        //모든 pair를 찾음 pair에 대해서 2^n
        dfs(chars, 0, 0);

        ArrayList<String> strings = new ArrayList<>(allAnswers);
        Collections.sort(strings);
        for (String s : strings) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(char[] chars, int nowD, int nowPairCnt) {
        if (nowD == allPair.size()) {
            if (nowPairCnt == 0) return;

            allAnswers.add(String.valueOf(chars).replaceAll(" ", ""));
            return;
        }

        chars[allPair.get(nowD)[0]] = ' ';
        chars[allPair.get(nowD)[1]] = ' ';
        dfs(chars, nowD + 1, nowPairCnt + 1);
        //복원
        chars[allPair.get(nowD)[0]] = '(';
        chars[allPair.get(nowD)[1]] = ')';

        dfs(chars, nowD + 1, nowPairCnt);

    }
}
