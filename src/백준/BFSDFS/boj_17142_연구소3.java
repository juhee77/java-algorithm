package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17142_연구소3 {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static final int WALL = 1;
    public static final int BLANK = 0;
    public static final int VIRUS = 2;
    private static int[][] map;
    private static boolean[][] visited;
    private static final List<int[]> virus = new ArrayList<>();
    private static int n, m;
    private static int min = Integer.MAX_VALUE;
    private static final Deque<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //input
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == VIRUS) virus.add(new int[]{i, j});
            }
        }

        //바이러스를 놓이게 할 수 있는 경우에 따라
        dfs(0, 0);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void dfs(int nowD, int start) {
        if (nowD == m) {
            findMin();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            int[] now = virus.get(i);
            q.add(now.clone());
            dfs(nowD + 1, i + 1);
            q.pollLast();
        }
    }

    private static void findMin() {
        //bfs
        Queue<int[]> queue = new LinkedList<>(q);
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            visit[i] = visited[i].clone();
        }

        int checkTime = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            int nowSize = queue.size();
            boolean activatedVirus = true;
            for (int i = 0; i < nowSize; i++) {
                int[] now = queue.poll();
                if (map[now[0]][now[1]] == 0) activatedVirus = false; //남아 있는것이 모두 활성 바이러스인 경우는 제하고 계산 해야한다.

                for (int[] dir : dirs) {
                    int movedX = now[0] + dir[0];
                    int movedY = now[1] + dir[1];
                    if (movedX < 0 || movedY < 0 || n <= movedX || n <= movedY || visit[movedX][movedY] || map[movedX][movedY] == WALL)
                        continue;
                    queue.add(new int[]{movedX, movedY});
                    visit[movedX][movedY] = true;
                }
            }
            if (!activatedVirus) { // 이번에 활성화된 바이러스가 아닌칸이 존재했다.
                checkTime = 0;
            } else if (checkTime == 0) {//이번에는 활성화된 바이러스칸만 있었다. 근데 이전에도 아니었다.
                checkTime = time;
            }
            time++;
        }

        if (checkingAllBlank(visit)) {
            if(checkTime!=0) time = checkTime;
            min = Math.min(min, time - 1);
        }
    }

    private static boolean checkingAllBlank(boolean[][] visit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}