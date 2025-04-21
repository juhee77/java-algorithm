package 프로그래머스.level2;

import java.util.Stack;

public class Programmers_76502_괄호회전하기_Stack {
    private static char[] sChar;

    public int solution(String s) {
        int answer = 0;

        sChar = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (isAble(s, i))
                answer++;
        }

        return answer;
    }

    public boolean isAble(String s, int startIdx) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            int nowIdx = (startIdx + j) % s.length();
            switch (sChar[nowIdx]) {
                case '[', '(', '{' -> stack.push(sChar[nowIdx]);
                case ']' -> {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else return false;
                }
                case ')' -> {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else return false;
                }
                case '}' -> {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Programmers_76502_괄호회전하기_Stack solution = new Programmers_76502_괄호회전하기_Stack();
        System.out.println(solution.solution("[](){}"));

    }
}
