package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17299_오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[size + 1];
        int[] dp = new int[1_000_001];
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[arr[i]]++;
        }

        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            int[] temp = new int[]{i, arr[i], dp[arr[i]]};
            while (!stack.isEmpty() && stack.peek()[2] < temp[2]) {
                int[] pop = stack.pop();
                ans[pop[0]] = temp[1]; //ans[가능 idx] = arr[i]
            }
            stack.push(temp);
        }

        for (int i = 1; i <= size; i++) {
            sb.append(ans[i] == 0 ? -1 : ans[i]).append(" ");
        }
        System.out.println(sb);

    }
}
