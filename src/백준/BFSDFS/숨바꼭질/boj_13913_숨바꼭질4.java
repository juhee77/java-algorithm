package 백준.BFSDFS.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13913_숨바꼭질4 {
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n, k));
    }

    private static String bfs(int n, int k) {
        if (n == k) return "0\n" + k;
        if (k < n) {
            StringBuilder sb = new StringBuilder();
            sb.append((n - k)).append("\n");
            for (int i = n; k <= i; i--) {
                sb.append(i).append(" ");
            }
            return sb.toString();
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int[] visited = new int[100001];
        int t = 1;
        Arrays.fill(visited, -1);
        visited[n] = -2;

        while (!queue.isEmpty()) {
            int nowTimeSize = queue.size();

            for (int i = 0; i < nowTimeSize; i++) {
                Integer now = queue.poll();

                if (checkAndAdd(now + 1, visited, queue, now) ||
                        checkAndAdd(now - 1, visited, queue, now) ||
                        checkAndAdd(now * 2, visited, queue, now)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(t).append("\n");
                    Stack<Integer> stack = new Stack<>();
                    int tempNow = k;
                    while (tempNow != -2) {
                        stack.push(tempNow);
                        tempNow = visited[tempNow];
                    }

                    while (!stack.isEmpty()) {
                        sb.append(stack.pop()).append(" ");
                    }
                    return sb.toString();
                }
            }
            t++;
        }
        return "-1";
    }

    private static boolean checkAndAdd(int moved, int[] visited, Queue<Integer> queue, int before) {
        if (moved < 0 || 100_000 < moved) return false;
        if (visited[moved] != -1) return false;
        queue.add(moved);
        visited[moved] = before;
        return moved == k;
    }

}
