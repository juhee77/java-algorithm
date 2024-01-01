package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_3015_오아시스재결합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long sum = 0;


        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{Integer.parseInt(br.readLine()), 1});//값, index


        for (int i = 2; i <= n; i++) {
            int now = Integer.parseInt(br.readLine());
            int[] temp = {now, 1};

            if (stack.peek()[0] == now) {
                temp = stack.pop();
                sum += temp[1];
                temp[1]++;
            } else {
                while (!stack.isEmpty() && stack.peek()[0] <= now) {
                    int[] pop = stack.pop();
                    sum += pop[1];
                    if (pop[0] == now) {
                        temp[1] += pop[1];
                    }
                }
            }

            if (!stack.isEmpty() && stack.peek()[0] > now) sum++;

            stack.push(temp);
        }
        System.out.println(sum);

    }
}
