package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cmd = br.readLine().toCharArray();

        double[] all = new double[26];
        for (int i = 0; i < n; i++) {
            all[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (char now : cmd) {
            if ('A' <= now && now <= 'Z') {
                stack.add(all[now - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double ans = 0;
                switch (now) {
                    case '*':
                        ans = a * b;
                        break;
                    case '/':
                        ans = a / b;
                        break;
                    case '+':
                        ans = a + b;
                        break;
                    case '-':
                        ans = a - b;
                        break;
                }
                stack.push(ans);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
