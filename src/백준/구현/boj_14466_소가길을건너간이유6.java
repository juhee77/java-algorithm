package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14466_소가길을건너간이유6 {
    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[][][] map; // 0 위 , 1 오른쪽, 2 아래 , 3 왼쪽
    private static int size;
    private static int[][] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int cow = Integer.parseInt(st.nextToken());
        int command = Integer.parseInt(st.nextToken());

        map = new int[size][size][5];
        while (command-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;

            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                if (startX + dir[0] == endX && startY + dir[1] == endY) {
                    map[startX][startY][i] = -1; //이동하지 못한다
                    map[endX][endY][(i + 2) % 4] = -1; //반대방향도 이동하지 못하는것을 저장
                    break;
                }
            }
        }

        cows = new int[cow][2];
        for (int i = 0; i < cow; i++) {
            st = new StringTokenizer(br.readLine());
            int cowX = Integer.parseInt(st.nextToken()) - 1;
            int cowY = Integer.parseInt(st.nextToken()) - 1;
            cows[i] = new int[]{cowX, cowY};
            map[cowX][cowY][4] = i + 1;// 위치한 소의 번호를 저장한다.
        }

        int sum = 0;
        for (int i = 0; i < cow; i++) {
            sum += (cow - 1 - bfs(i)); //만난친구숫자를 뺀다
        }

        System.out.println(sum / 2); // 소의 쌍 이기때문에
    }

    private static int bfs(int idx) {
        boolean[][] visited = new boolean[size][size];
        visited[cows[idx][0]][cows[idx][1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(cows[idx]);
        int visitCnt = 0; // 만난 소의 수

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int mvx = now[0] + dir[0];
                int mvy = now[1] + dir[1];

                if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy || visited[mvx][mvy]) {
                    continue;
                }
                if (map[now[0]][now[1]][i] == -1) {
                    continue; //갈수 없는 길}
                }

                if (map[mvx][mvy][4] != 0) { //소를 만났다
                    visitCnt++;
                }
                visited[mvx][mvy] = true;
                queue.add(new int[]{mvx, mvy});
            }
        }
        return visitCnt;
    }
}
