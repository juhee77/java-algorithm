package 백준.dynamicProgramming;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9177_단어섞기2_BFS {
    private static char[][] input = new char[3][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append("Data set ").append(i).append(": ");
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[j] = st.nextToken().toCharArray();
            }

            sb.append(getFlag() ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean getFlag() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] dp = new boolean[input[0].length + 1][input[1].length + 1];
        queue.add(new Point(0, 0));
        dp[0][0] = true;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int nowDepth = poll.x + poll.y;
            if (nowDepth == input[2].length) return true;

            if (poll.x < input[0].length && !dp[poll.x + 1][poll.y] && input[0][poll.x] == input[2][nowDepth]) {
                dp[poll.x + 1][poll.y] = true;
                queue.add(new Point(poll.x + 1, poll.y));
            }

            if (poll.y < input[1].length && !dp[poll.x][poll.y + 1] && input[1][poll.y] == input[2][nowDepth]) {
                dp[poll.x][poll.y + 1] = true;
                queue.add(new Point(poll.x, poll.y + 1));
            }
        }
        return false;
    }

}
//bbbb bbbbasdf bbbbasdfbbbb --> 잘못된 풀이임