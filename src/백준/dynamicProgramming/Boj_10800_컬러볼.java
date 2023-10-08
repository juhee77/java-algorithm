package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10800_컬러볼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Ball> balls = new PriorityQueue<>();
        int ballMax = 0;
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            ballMax = Math.max(ballMax, weight);
            Ball e = new Ball(i, color, weight);
            balls.add(e);
        }

        //컬러별 무게 0은 전체 무게 (전체 무게 - 현재 컬러의 무게 빼면 컬러볼 최대 점수 추측 가능)
        int[] dp = new int[cnt+1];

        int[] ans = new int[cnt];
        while (!balls.isEmpty()) {
            List<Ball> temp = new ArrayList<>();
            Ball poll = balls.poll();
            temp.add(poll);
            ans[poll.index] = dp[0] - dp[poll.color];
            while (!balls.isEmpty() && poll.weight == balls.peek().weight) {
                Ball poll1 = balls.poll();
                temp.add(poll1);
                ans[poll1.index] = dp[0] - dp[poll1.color];
            }

            //무게 업데이트
            for (Ball ball : temp) {
                dp[0] += ball.weight;
                dp[ball.color] += ball.weight;
            }
        }

        for (int an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }

    public static class Ball implements Comparable<Ball> {
        int index;
        int color;
        int weight;

        public Ball(int index, int color, int weight) {
            this.index = index;
            this.color = color;
            this.weight = weight;
        }

        @Override
        public int compareTo(Ball o) {
            return weight - o.weight;//가벼운것 먼저
        }
    }
}


