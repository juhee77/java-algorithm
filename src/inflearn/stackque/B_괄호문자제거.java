package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_괄호문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        System.out.println(solution(arr));
        System.out.println(solution2(new String(arr)));
    }


    private static String solution2(String str) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(') ;
            } else stack.push(x);
        }
        for (Character character : stack) answer.append(character);
        return answer.toString();
    }

    private static String solution(char[] arr) {
        Stack<Character> s = new Stack<>();
        for (char c : arr) {
            if (c == ')') {
                while (s.peek() != '(') {
                    s.pop();
                }
                s.pop();
            } else {
                s.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}
