package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15684_사다리조작 {
    private static int ver; //세로선
    private static int hor; //가로선
    private static int H; // 가로선 둘수 있는
    private static boolean visited[][];
    private static int min = Integer.MAX_VALUE;

    //둘수도 있고 안둘수도 있고
    private static void dfs(int n, int line) {
        if (line > 3) return; //이거 안하면 무한루프 돈다

        if (n == ver - 1) {
            if (check()) min = Math.min(line, min);
        } else {
            //두지 않는경우
            dfs(n + 1, line);
            //두는경우(마음대로 한줄에 하나씩만 들어올거라고 일반화 하지 말고
            //그냥 다 돌려보기로 했으면 일단 다 돌려보자..
            for (int i = 0; i < H; i++) {
                if (!visited[i][n]) {
                    if (n == 0) {
                        if (!visited[i][n + 1]) visit(n, line, i);
                    } else if (n == ver - 2) {
                        if (!visited[i][n - 1]) visit(n, line, i);
                    } else {
                        if (!visited[i][n - 1] && !visited[i][n + 1])visit(n, line, i);
                    }

                }
            }
        }
    }

    private static void visit(int n, int line, int i) {
        visited[i][n] = true;
        dfs(n, line + 1);
        visited[i][n] = false;
    }

    private static void print() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }


    private static boolean check() {
        boolean f = true;
        for (int i = 0; i < ver && f; i++) {
            int nowx = i;
            for (int j = 0; j < H; j++) {
                if (nowx > 0 && visited[j][nowx - 1])
                    nowx--;
                else if (visited[j][nowx])
                    nowx++;
            }
            if (nowx != i) f = false;
//            System.out.println(i+"는 "+nowx);
        }
        return f;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ver = Integer.parseInt(st.nextToken());
        hor = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new boolean[H][ver];
        for (int i = 0; i < hor; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            visited[a][b] = true;
        }
        if (check()) System.out.println(0); //처음부터 이미 되는경우
        else {
            dfs(0, 0);
            System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
        }
    }
}
