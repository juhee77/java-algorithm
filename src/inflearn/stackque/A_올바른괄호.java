package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class A_올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution2(str));
        System.out.println(solution(str.toCharArray()) ? "YES" : "NO");
    }

    private static String solution2(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }

    private static boolean solution(char[] arr) {
        Stack<Character> s = new Stack<>();
        for (char c : arr) {
            if (c == '(') s.push(c);
            else {
                if (s.isEmpty()) return false;
                s.pop();
            }
        }
        return s.size() == 0;
    }
}
