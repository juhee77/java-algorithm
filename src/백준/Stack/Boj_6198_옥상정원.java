package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boj_6198_옥상정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        Stack<long[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            arr.add(now);
        }

        long cnt = 0;
        for (int i = n - 1; 0 <= i; i--) {
            long temp = 0;
            while (!stack.isEmpty() && stack.peek()[0] < arr.get(i)) {
                long[] pop = stack.pop();
                cnt += pop[1];
                temp += pop[1];
            }
            stack.add(new long[]{arr.get(i), temp + 1});
        }

        System.out.println(cnt);
    }
}
