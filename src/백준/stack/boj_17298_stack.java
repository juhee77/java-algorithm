package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17298_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int line = Integer.parseInt(br.readLine());
        Stack<Integer> list = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[line];
        int[] ans = new int[line];

        for (int i = 0; i < line; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            while (!stack.isEmpty() && temp > arr[stack.peek()]) {
                ans[stack.pop()] = temp;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) ans[stack.pop()] = -1;
        for (int i : ans) sb.append(i + " ");
        System.out.println(sb);


    }
}
