package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2629_양팔저울_2 {
    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tc = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());


        while (tc-- > 0) {
            int goalScore = Integer.parseInt(st.nextToken());
            if (isAble(goalScore)) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    private static boolean isAble(int goalScore) {
        Queue<Integer> q = new LinkedList<>();
        q.add(goalScore);
        boolean[] visited = new boolean[1000000];
        int mid = 500000;
        visited[mid + goalScore] = true;
        int i = 0;

        while (!q.isEmpty() && i <= n) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Integer poll = q.poll();
                if (poll == 0) {
                    return true;
                }

                if (i == n) {
                    continue;
                }

                int i1 = poll + arr[i];
                if (!visited[mid + i1]) {
                    q.add(i1);
                    visited[mid + i1] = true;
                }

                int i2 = poll - arr[i];
                if (!visited[mid + i2]) {
                    q.add(i2);
                    visited[mid + i2] = true;
                }

                q.add(poll);
            }
            i++;
        }

        return false;
    }
}
