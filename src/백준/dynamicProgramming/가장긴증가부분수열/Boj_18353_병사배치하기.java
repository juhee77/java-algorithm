package 백준.dynamicProgramming.가장긴증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_18353_병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] < stack.peek()) {
                stack.push(arr[i]);
            } else {
                int start = 0;
                int end = stack.size() - 1;

                while (start < end) {
                    int mid = (start + end) / 2;//(start+end)>>1;
                    if (stack.get(mid) <= arr[i]) end = mid;
                    else start = mid + 1;
                }
                stack.set(start, arr[i]);
            }
        }
        System.out.println(n - (stack.size() - 1));
    }
}
