package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2251_물통 {
    private static int a, b, c;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[a + 1][b + 1][c + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = {0, 0, c};
        queue.add(start);
        visited[0][0][c] = true;
        boolean[] ans = new boolean[c + 1];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
//            System.out.println(Arrays.toString(poll) + a + " " + b + " " + c);
            if (poll[0] == 0) ans[poll[2]] = true;

            int move = Math.min(poll[0], c - poll[2]);
            int[] ints = {poll[0] - move, poll[1], poll[2] + move};
            if (checkVisit(ints)) {
                queue.add(ints);
                visited[ints[0]][ints[1]][ints[2]] = true;
            }

            move = Math.min(poll[1], c - poll[2]);
            ints = new int[]{poll[0], poll[1] - move, poll[2] + move};
            if (checkVisit(ints)) {
                queue.add(ints);
                visited[ints[0]][ints[1]][ints[2]] = true;
            }

            move = Math.min(poll[2], a - poll[0]);
            ints = new int[]{poll[0] + move, poll[1], poll[2] - move};
            if (checkVisit(ints)) {
                queue.add(ints);
                visited[ints[0]][ints[1]][ints[2]] = true;
            }

            move = Math.min(poll[1], a - poll[0]);
            ints = new int[]{poll[0] + move, poll[1] - move, poll[2]};
            if (checkVisit(ints)) {
                queue.add(ints);
                visited[ints[0]][ints[1]][ints[2]] = true;
            }

            move = Math.min(poll[0], b - poll[1]);
            ints = new int[]{poll[0] - move, poll[1] + move, poll[2]};
            if (checkVisit(ints)) {
                queue.add(ints);
                visited[ints[0]][ints[1]][ints[2]] = true;
            }

            move = Math.min(poll[2], b - poll[1]);
            ints = new int[]{poll[0], poll[1] + move, poll[2] - move};
            if (checkVisit(ints)) {
                queue.add(ints);
                visited[ints[0]][ints[1]][ints[2]] = true;
            }
        }

        for (int i = 0; i <= c; i++) {
            if (ans[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    private static boolean checkVisit(int[] poll) {
        if (0 > poll[0] || 0 > poll[1] || 0 > poll[2]) return false;
        if (poll[0] >= a + 1 || poll[1] >= b + 1 || poll[2] >= c + 1) return false;
        if (visited[poll[0]][poll[1]][poll[2]]) return false;
        return true;
    }

}
