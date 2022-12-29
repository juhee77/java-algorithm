package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2573_빙산 {

    /*
    1. 로테이션 한번당 빙산의 높이가 0이상인경우 사방으로 0이 몇개 인지 확인
    2. 모든 탐색 끝나면 Math.min(기종- 녹을것,0)
    3. 땅이 몇덩이로 나뉘었는지 확인
    3-1. 땅이 2덩이 이상이면 멈춤
    3-2 땅이 1이면 1번부터 반복
    4. 만약 모든 빙산이 녹은 상태라면 멈춤
     */

    private static int[][] map;
    private static boolean[][] visited;
    private static int row, col;
    private static final int[] dirX = new int[]{-1, 1, 0, 0};
    private static final int[] dirY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int iLands;
        int year = 0;
        while (true) { //빙산이 있는 경우 까지
            //분리된 땅의 개수 확인
            iLands = 0;
            visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        iLands++;
                        bfs(i, j);
                    }
                }
            }

            //땅이 2개 이상으로 나누어졌다면
            if (2 <= iLands) return year;

            year++;

            //녹는 양
            int[][] melted = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (0 < map[i][j]) {
                        melted[i][j] = checkingMelting(i, j);
                    }
                }
            }


            //녹고 난 후
            boolean flag = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = Math.max(0, map[i][j] - melted[i][j]);
                    if (map[i][j] > 0) flag = false;
                }
            }

            //만약 빙산이 다 녹았다면
            if (flag) return 0;

        }
    }

    //4방위에 바다가 몇칸 있는지
    private static int checkingMelting(int i, int j) {
        int count = 0;
        for (int dir = 0; dir < 4; dir++) {
            int mvX = i + dirX[dir];
            int mvY = j + dirY[dir];
            //벗어남
            if (mvX >= row || mvX < 0 || mvY < 0 || mvY >= col) continue;
            if (map[mvX][mvY] == 0) count++;
        }
        return count;
    }

    //분리된 땅의 개수를 센다.
    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mvX = temp[0] + dirX[i];
                int mvY = temp[1] + dirY[i];

                //벗어남
                if (mvX >= row || mvX < 0 || mvY < 0 || mvY >= col) continue;

                //방문하지 않았으면
                if (!visited[mvX][mvY] && map[mvX][mvY] > 0) {
                    visited[mvX][mvY] = true;
                    queue.add(new int[]{mvX, mvY});
                }
            }
        }
    }
}
