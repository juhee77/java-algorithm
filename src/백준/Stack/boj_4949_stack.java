package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4949_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        while (true) {
            String s = br.readLine();
            //System.out.println(s);
            if (s.equals(".")) break;
            int flag = 1;
            char c[] = s.toCharArray();
            stack.clear();

            for (int j = 0; j < c.length; j++) {

                if (c[j] == '(' || c[j] == '[') stack.push(c[j]);
                else if (c[j] == ')') {
                    if (stack.isEmpty() ||  stack.pop() == '[') flag = 0;
                }
                else if (c[j] == ']') {
                    if (stack.isEmpty() || stack.pop() == '(') flag = 0;
                }
            }
            if (flag == 1 && stack.isEmpty()) sb.append("yse\n");
            else sb.append("no\n");
        }
        System.out.println(sb);

    }
}
