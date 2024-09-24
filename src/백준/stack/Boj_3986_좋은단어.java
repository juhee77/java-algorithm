package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ansCnt = 0;
        while (n-- > 0) {
            char[] chars = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char aChar : chars) {
                if (!stack.isEmpty() && stack.peek() == aChar)
                    stack.pop();
                else
                    stack.add(aChar);
            }

            if (stack.isEmpty()) {
                ansCnt++;
            }
        }
        System.out.println(ansCnt);
    }
}
