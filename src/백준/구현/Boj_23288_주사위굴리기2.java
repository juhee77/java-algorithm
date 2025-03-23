package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_23288_주사위굴리기2 {
    private static int[][] dfsMap;
    private static int[][] map;
    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동, 남, 서, 북
    private static boolean[][] visitedMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. DFS로 영역별 점수 계산 (BFS 방식 사용)
        dfsMap = new int[n][m];
        visitedMap = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedMap[i][j]) {
                    bfs(i, j); // BFS를 사용하여 같은 영역을 탐색하고 점수를 할당
                }
            }
        }

        // 2. 주사위 이동 시작
        int[] cube = {2, 1, 5, 6, 4, 3}; // 주사위 초기 상태
        int x = 0, y = 0;
        int dir = 0; // 동쪽(→)부터 시작
        long sum = 0;

        for (int i = 0; i < turn; i++) {
            // 2-1. 이동 가능 여부 확인
            int mvX = x + dirs[dir][0];
            int mvY = y + dirs[dir][1];

            if (!canMove(mvX, mvY)) {
                dir = (dir + 2) % 4; // 반대 방향으로 회전
                mvX = x + dirs[dir][0];
                mvY = y + dirs[dir][1];
            }

            // 주사위 이동
            cube = rotate(cube, dir);
            x = mvX;
            y = mvY;

            // 2-2. 주사위 점수 획득
            sum += dfsMap[x][y];

            // 2-3. 주사위 아랫면과 지도 숫자 비교하여 이동 방향 변경
            int A = cube[3]; // 주사위 아랫면 값
            int B = map[x][y];

            if (A > B) {
                dir = (dir + 1) % 4; // 시계 방향 회전
            } else if (A < B) {
                dir = (dir + 3) % 4; // 반시계 방향 회전
            }
        }

        System.out.println(sum);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> region = new ArrayList<>();
        queue.add(new int[]{i, j});
        region.add(new int[]{i, j});
        visitedMap[i][j] = true;

        int count = 1;
        int number = map[i][j];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (canMove(nx, ny) && !visitedMap[nx][ny] && map[nx][ny] == number) {
                    visitedMap[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    region.add(new int[]{nx, ny});
                    count++;
                }
            }
        }

        // 같은 숫자로 연결된 모든 칸에 점수 저장
        int score = count * number;
        for (int[] pos : region) {
            dfsMap[pos[0]][pos[1]] = score;
        }
    }

    private static int[] rotate(int[] cube, int dir) {
        if (dir == 0) { // 동쪽(→)
            return new int[]{cube[0], cube[4], cube[2], cube[5], cube[3], cube[1]};
        } else if (dir == 1) { // 남쪽(↓)
            return new int[]{cube[3], cube[0], cube[1], cube[2], cube[4], cube[5]};
        } else if (dir == 2) { // 서쪽(←)
            return new int[]{cube[0], cube[5], cube[2], cube[4], cube[1], cube[3]};
        } else { // 북쪽(↑)
            return new int[]{cube[1], cube[2], cube[3], cube[0], cube[4], cube[5]};
        }
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < map.length && 0 <= y && y < map[0].length;
    }
}
