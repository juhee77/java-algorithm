package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10773_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        ;

        int cnt = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;

        for (int i = 0; i < cnt; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) sum -= stack.pop();
            else {
                stack.push(input);
                sum += input;
            }
        }
        sb.append(sum);
        System.out.println(sb);

    }
}
