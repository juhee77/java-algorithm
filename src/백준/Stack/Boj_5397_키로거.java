package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        while (tc-- > 0) {
            char[] cmd = br.readLine().toCharArray();

            left.clear();
            right.clear();
            for (char c : cmd) {
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.addLast(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.addFirst(right.pop());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pollLast();
                        }
                        break;
                    default:
                        left.addLast(c);
                }
            }

            while (!left.isEmpty()) {
                sb.append(left.pollFirst());
            }

            while (!right.isEmpty()) {
                sb.append(right.pollLast());
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
