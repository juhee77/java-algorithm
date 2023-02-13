package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1082_방번호 {
    private static class Number implements Comparable<Number> {
        int money;
        int[] num;

        public Number(int money, int[] num) {
            this.money = money;
            this.num = num;
        }

        @Override
        public int compareTo(Number other) {

            int sumA = Arrays.stream(this.num).sum();
            int sumB = Arrays.stream(other.num).sum();
            if (sumA == sumB || sumA == this.num[0] || sumB == other.num[0]) {

                for (int i = 9; 0 <= i; i--) {
                    if (num[i] < other.num[i]) {
                        return 1;
                    } else if (num[i] > other.num[i]) {
                        return -1; // - 나오면 가만 둔다.
                    }
                }
                return other.money - this.money;
            }

            if (sumA < sumB) return 1;
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int goal = Integer.parseInt(br.readLine());
        int[][] dp = new int[501][10];
        int[] max = new int[10];
        PriorityQueue<Number> pq = new PriorityQueue<>();
        pq.add(new Number(goal, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        while (!pq.isEmpty()) {
            Number poll = pq.poll();
            // if(dp[poll.money]>poll.num) continue;

            for (int i = n - 1; 0 <= i; i--) {
                if (poll.money < p[i]) continue;
                poll.num[i] += 1;

                if (compareNum(dp[poll.money - p[i]], poll.num)) {
                    poll.num[i] -= 1;
                    continue;
                }
                int[] clone = poll.num.clone();
                dp[poll.money - p[i]] = clone;
                pq.add(new Number(poll.money - p[i], dp[poll.money - p[i]]));
                max = (compareNum(max, poll.num)) ? max : poll.num.clone();

                poll.num[i] -= 1;
            }
        }

        if (Arrays.stream(max).sum() == max[0]) {
            sb.append("0");
        } else {
            for (int i = n - 1; 0 <= i; i--) {
                sb.append(String.valueOf(i).repeat(max[i]));
            }
        }
        System.out.println(sb);
    }

    public static boolean compareNum(int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        if (sumA == sumB || sumA == a[0] || sumB == b[0]) {
            for (int i = 9; 0 <= i; i--) {
                if (a[i] > b[i]) {
                    return true;
                } else if (a[i] < b[i]) {
                    return false; // - 나오면 가만 둔다.
                }
            }
            return false;
        }
        return sumA > sumB;
    }
}
