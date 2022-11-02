package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603_로또_3 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int next = Integer.parseInt(st.nextToken());
        while (next != 0) {
            arr = new int[next];
            visited = new boolean[next];

            for (int i = 0; i < next; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            next = Integer.parseInt(st.nextToken());

        }
        System.out.println(sb);
    }

    private static void dfs(int d, int start) {
        if (d == 6) { //6개를 뽑는다
            printLotto();
        } else {
            for (int i = start; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs( d + 1, i + 1);
                    visited[i] = false;
                }
            }
        }

    }

    private static void printLotto() {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }
}
