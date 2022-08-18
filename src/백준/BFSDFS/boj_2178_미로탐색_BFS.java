package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178_미로탐색_BFS {

    private static int bfs(int arr[][], int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int dirx[] = new int[]{-1, 1, 0, 0};
        int diry[] = new int[]{0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            int px = (int) temp.getX();
            int py = (int) temp.getY();

            for (int i = 0; i < 4; i++) {
                int nx = px + dirx[i];
                int ny = py + diry[i];

                //벗어남
                if (nx >= arr.length || nx < 0 || ny < 0 || ny >= arr[0].length) continue;

                //벽이면
                if (arr[nx][ny] == 0) continue;

                //방문안한 노드이면
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[px][py] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return arr[arr.length-1][arr[0].length-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int arr[][] = new int[row][col];
        //입력구간
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++)
                arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
        }

        //bfs
        int cnt = bfs(arr, 0, 0);
        System.out.println(cnt);

    }
}
