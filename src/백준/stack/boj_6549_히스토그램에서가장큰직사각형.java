package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_6549_히스토그램에서가장큰직사각형 {
    private static int cnt;
    private static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());

        //왼쪽부터 오른쪽 n개
        while (cnt != 0) {
            height = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(findMaxInRange()).append("\n");
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);

    }

    private static long findMaxInRange() {
        Stack<Integer> stack = new Stack<>(); //위로 쌓일 수록 큰 사이즈
        long max = 0;


        for (int i = 0; i <= cnt - 1; i++) {

            int pop = -1;
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {

                pop = stack.pop();
                max = Math.max(max, (long) height[pop] * (i - pop));
                height[pop] = height[i];
            }

            if (pop != -1) stack.push(pop);
            else stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            max = Math.max(max, (long) height[pop] * (cnt - pop));
        }

        return max;
    }
}
