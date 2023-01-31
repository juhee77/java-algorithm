package inflearn.dfs_bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class L_토마토_bfs {
    private static int row, col;
    private static int[][] sol1Map, sol2Map;
    private static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final Queue<Point> queue2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        sol1Map = new int[row][col];


        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                sol1Map[i][j] = Integer.parseInt(st.nextToken());
                if (sol1Map[i][j] == 1) queue2.add(new Point(i, j));
            }
        }
        sol2Map = clone2DimensionArray(sol1Map);

        System.out.println("=== solution 1 ===");
        System.out.println(solution1());
        System.out.println("=== solution 2 ===");
        System.out.println(solution2());
    }

    private static int[][] clone2DimensionArray(int[][] map) {
        int[][] arr = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            arr[i] = map[i].clone();
        }
        return arr;
    }

    private static int solution2() {
        int[][] sol2Visited = new int[row][col];
        while (!queue2.isEmpty()) {
            Point now = queue2.poll();
            for (int[] ints : dir) {
                int movedX = now.x + ints[0];
                int movedY = now.y + ints[1];

                if (0 <= movedX && movedX < row && 0 <= movedY && movedY < col && sol2Map[movedX][movedY] == 0) {
                    //익지 않은 토마토에 대해서
                    sol2Visited[movedX][movedY] = sol2Visited[now.x][now.y] + 1;
                    sol2Map[movedX][movedY] = 1; //토마토가 익었다.
                    queue2.add(new Point(movedX, movedY));
                }
            }
        }

        int ans =0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sol1Map[i][j] == 0) return -1;
                else ans = Math.max(ans, sol2Visited[i][j]);
            }
        }
        return ans;
    }


    /**
     * 이렇게 풀지 말고 입력을 받으면서 익은 토마토를 기억하고 큐를 돈다.
     * boolean 배열을 사용하지 않고 익게 되는 날짜를 적어서 가장 오래된 날짜를 출력한다.
     * 만약 queue가 비워질때까지 반복되었다면 int배열에서 가장 긴날짜를 구한다. 하지만 만약 익지 못하 토마토가 있으면 -1을 출력한다.
     * vi[movedx][movedy] = vi[now.x][now.y]+1 과 같이 계속해서 계산 -> solution 2 방법으로 수정 함
     *
     * @return findMinDay
     */
    private static int solution1() {
        int day = -1;
        boolean haveToCheck = true;
        while (haveToCheck) {
            haveToCheck = false;
            //오늘 익은 건지 (오늘익은건 다른것에 영향 주지 않음)
            boolean[][] sol1Visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    if (sol1Map[i][j] == 1 && !sol1Visited[i][j]) {
                        haveToCheck = ripeTomato(haveToCheck, sol1Visited, i, j);
                    }

                }
            }
            day++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (sol1Map[i][j] == 0) return -1; //완숙 되지 않은것이 있음
            }
        }
        return day;
    }

    private static boolean ripeTomato(boolean flag, boolean[][] sol1Visited, int i, int j) {
        for (int[] ints : dir) {
            int moveI = i + ints[0];
            int moveJ = j + ints[1];
            if (moveI < 0 || moveJ < 0 || row <= moveI || col <= moveJ) continue;
            if (sol1Map[moveI][moveJ] == 0) {
                sol1Visited[moveI][moveJ] = true;
                sol1Map[moveI][moveJ] = 1;
                flag = true; //익은게 있다-> 다음 탐색 계속해서
            }

        }
        return flag;
    }
}
