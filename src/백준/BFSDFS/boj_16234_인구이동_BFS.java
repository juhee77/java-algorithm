package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16234_인구이동_BFS {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int L, R;

    private static boolean bfs(int x, int y, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        ArrayList<Point> open = new ArrayList<>();
        open.add(new Point(x, y));
        int people = arr[x][y];
        visited[x][y] = true;

        int dirx[] = new int[]{-1, 1, 0, 0}; //인접 나라
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

                //이전에 방문 하지 않았다면
                if (!visited[nx][ny]) {
                    //만약 범위를 벗어나지 않으면다음거 넣기
                    if (checkPeopleNums(arr[px][py], arr[nx][ny])) {
                        visited[nx][ny] = true;
                        people += arr[nx][ny];
                        open.add(new Point(nx, ny));
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        if (open.size() >= 2) {
            int div = people / open.size();

            for (int i = 0; i < open.size(); i++) {
                Point temp = open.get(i);
                arr[temp.x][temp.y] = div;
            }
            return true;
        } else return false;

    }

    private static boolean checkPeopleNums(int a, int b) {
        int tem = Math.abs(a - b);
        if (L <= tem && tem <= R) return true;
        else return false;
    }

    private static boolean afterOneDay() {
        visited = new boolean[arr.length][arr.length];
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!visited[i][j]) {
                    flag = bfs(i, j, visited) ||flag;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        arr = new int[row][row];
        //입력구간
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        //bfs
        while (afterOneDay()) {
            cnt++;
        }

        System.out.println(cnt);

    }
}
