package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_2504_괄호의값 {
    private static class Pro {
        char nowChar;
        int num;

        public Pro(char nowChar, int num) {
            this.nowChar = nowChar;
            this.num = num;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Pro> s = new Stack<>();
        char[] input = br.readLine().toCharArray();

        boolean isRight = true;
        for (char c : input) {
            if (c == '(' || c == '[') {
                s.add(new Pro(c, 1));
                continue;
            }

            int temp = 0;
            while (!s.isEmpty() && s.peek().nowChar == '.') {
                temp += s.pop().num;
            }
            if (c == ')') {
                if (!s.isEmpty() && s.peek().nowChar == '(') {
                    s.pop();
                    if (temp == 0) {
                        temp += 2;
                    } else {
                        temp *= 2;
                    }

                    s.add(new Pro('.', temp));
                } else {
                    isRight = false;
                    break;
                }
            } else if (c == ']') {
                if (!s.isEmpty() && s.peek().nowChar == '[') {
                    s.pop();
                    if (temp == 0) {
                        temp += 3;
                    } else {
                        temp *= 3;
                    }

                    s.add(new Pro('.', temp));
                } else {
                    isRight = false;
                    break;
                }
            }
        }

        int ans = 0;
        while (!s.isEmpty() && s.peek().nowChar=='.') {
            ans += s.pop().num;
        }

        //괄호가 다 비워져 있지 않으면
        if (!s.isEmpty()) {
            isRight = false;
        }


        if (isRight) {
            System.out.println(ans);
        } else {
            System.out.println(0);
        }
    }
}
