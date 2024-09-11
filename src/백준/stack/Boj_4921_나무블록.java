package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_4921_나무블록 {
    private static final String[] arr = new String[]{"|[", "]|", "][", "ㅓㅏ", "ㅓ(", ")ㅏ", ")(", "<>"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i = 0; //문제 번호
        String temp;//입력 문자열
        while (!(temp = br.readLine()).equals("0")) {
            i++;
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            for (char c : temp.toCharArray()) {
                for (char tc : arr[c - '1'].toCharArray()) {
                    if (!stack.isEmpty() && ((stack.peek() == '[' && tc == 'ㅓ')
                            || (stack.peek() == 'ㅏ' && tc == ']')
                            || (stack.peek() == '(' && tc == '<')
                            || (stack.peek() == '>' && tc == ')')
                            || (stack.peek() == '|' && tc == '|')
                    )) {
                        stack.pop();
                    } else stack.push(tc);

                }
                if (stack.isEmpty()) cnt++;
            }

//            System.out.println(stack);
            sb.append(i + ".");
            if (stack.isEmpty() && cnt == 1) {
                sb.append(" VALID\n");
            } else sb.append(" NOT\n");
        }
        System.out.println(sb);
    }

}
