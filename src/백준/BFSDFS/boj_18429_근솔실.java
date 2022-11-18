package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_18429_근솔실 {
    private static List<Integer> ex = new ArrayList<>();
    private static boolean[] visited;
    private static int cs = 0;
    private static int minus;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        visited = new boolean[day];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < day; i++) {
            ex.add(Integer.parseInt(st.nextToken()));
        }
        dfs(0, day, 500);
        System.out.println(cs);
    }

    private static void dfs(int depth, int n, int nowCan) {
        if (depth == n) {
            cs++;
        } else {
            nowCan -= minus;
            for (int i = 0; i < ex.size(); i++) {
                if (!visited[i] && nowCan + ex.get(i) >= 500) {
                    visited[i] = true;
                    dfs(depth + 1, n, nowCan + ex.get(i));
                    visited[i] = false;
                }
            }
        }
    }
}
