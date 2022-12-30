package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2812_Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = N - Integer.parseInt(st.nextToken()); // 남아야 할 수

        char[] nums = br.readLine().toCharArray();
        Stack<Integer> s = new Stack<>();
        Deque<Integer> ans = new LinkedList<>();

        for (int i = N - 1; 0 <= i; i--) {
            s.add(nums[i] - '0');
        }

        ans.add(s.pop());
        while (!s.isEmpty()) {
            int now = s.pop();
//            System.out.println(ans);
            while (!ans.isEmpty() && ans.peekLast() < now && K - ans.size() <= s.size()) {
                ans.pollLast();
            }
            ans.addLast(now);
        }

        while (!ans.isEmpty() && sb.length() < K) {
            sb.append(ans.pollFirst());
        }

        System.out.println(sb);
    }
}
