package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pointDslr {
    int x;
    String cmd;

    public pointDslr(int x, String cmd) {
        this.x = x;
        this.cmd = cmd;
    }

    public int getX() {
        return x;
    }


    public String getCmd() {
        return cmd;
    }
}

public class boj_9019_DSLR {
    private static String bfs(int be, int af) {

        Queue<pointDslr> queue = new LinkedList<>();
        queue.add(new pointDslr(be, ""));
        boolean visited[] = new boolean[10001];
        visited[be] = true;

        while (!queue.isEmpty()) {
            pointDslr temp = queue.poll();
            int px = temp.getX();
            String py = temp.getCmd();

            if (px == af) {
                queue.clear();
                return py;
            }

            //벗어남
            if (px > 10000 || px < 0) continue;

            int nx = px;
            //방문안한 노드이면(각케이스별로)
            //case 'D':
            nx = (px * 2) % 10000;
            if (0 <= nx && nx < 10000)
                if (!visited[nx]) {
                    queue.add(new pointDslr(nx, py + 'D'));
                    visited[nx] = true;
                }

            //case 'S':
            nx = (px == 0) ? 9999 : px - 1;
            if (0 <= nx && nx < 10000)
                if (!visited[nx]) {
                    queue.add(new pointDslr(nx, py + 'S'));
                    visited[nx] = true;
                }

            //case 'L':
            String str = String.valueOf(px);
            str = "0".repeat(4 - str.length()) + str;
            nx = Integer.parseInt(str.substring(1) + str.substring(0, 1));
            if (0 <= nx && nx < 10000)
                if (!visited[nx]) {
                    queue.add(new pointDslr(nx, py + 'L'));
                    visited[nx] = true;
                }

            //case 'R':
            str = String.valueOf(px);
            str = "0".repeat(4 - str.length()) + str;
            nx = Integer.parseInt(str.substring(str.length() - 1) + str.substring(0, str.length() - 1));
            if (0 <= nx && nx < 10000)
                if (!visited[nx]) {
                    queue.add(new pointDslr(nx, py + 'R'));
                    visited[nx] = true;
                }
        }

        return "ERROR";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            //bfs
            String ans = bfs(before, after);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
