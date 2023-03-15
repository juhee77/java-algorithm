package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_19237_어른상어 {
    //1. 상어가 움직이는 시점은 모든 상어가 움직이고 난훈.
    //2. 상어가 움직이고 난후 같은 칸에 상어가 여러마리 있는경우 숫자가 낮은 상어만 남는다
    //3. 이전의 칸들에 대해서 냄새의 타임을 1씩 줄인다
    //4. 상어가 움직인 경우에 따라 칸을 채운다
    //5. 1인 상어만 남을때까지 반복한다.
    private static int N, M, K;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static class Shark {
        int idx;
        int x, y;
        int nowDir;
        int[][] dirs = new int[4][4];

        public Shark(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public void setNowDir(int x) {
            this.nowDir = x;
        }

        public void setDir(int[][] dirs) {
            this.dirs = dirs;
        }

        public void movedNext() {
            int[] nowDirs = dirs[nowDir];
            int keepDir = -1;
            for (int dir : nowDirs) {
                int movedX = x + move[dir][0];
                int movedY = y + move[dir][1];
                if (movedX < 0 || movedY < 0 || N <= movedX || N <= movedY) continue;
                if (map[movedX][movedY][0] == this.idx && keepDir == -1) {
                    keepDir = dir;
                    continue;
                }

                if (map[movedX][movedY][1] > 0) continue;

                nowDir = dir;
                x = movedX;
                y = movedY;
                return;
            }
            //어떤곳으로도 가지 못하는 경우 자신이 원래 있던 칸으로 돌아간다 향기는 2초이상이므로 없는 경우능 없다)
            nowDir = keepDir;
            x += move[nowDir][0];
            y += move[nowDir][1];
        }

    }

    private static int[][][] map; //x,y ->남은 시간
    private static final HashMap<Integer, Shark> sharks = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //size
        M = Integer.parseInt(st.nextToken()); //상어 마리수
        K = Integer.parseInt(st.nextToken()); //k만큼의 시간동아 냄새가 남는다

        map = new int[N][N][2];
        //init
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now != 0) {
                    sharks.put(now, new Shark(now, i, j));
                    map[i][j][0] = now;
                    map[i][j][1] = K;
                }
            }

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks.get(i).setNowDir(Integer.parseInt(st.nextToken()) - 1);
        }

        //set DIR
        for (int i = 1; i <= M; i++) {
            int[][] dirs = new int[4][4];
            for (int p = 0; p < 4; p++) {
                st = new StringTokenizer(br.readLine());
                for (int q = 0; q < 4; q++) {
                    dirs[p][q] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
            sharks.get(i).setDir(dirs);
        }

        int time = 0;
        while (sharks.size() > 1 && time <= 1000) {
            time++;
            movedShark();
            reduceEachCellSmell();
            checkingDuplicate();
        }

        if (time > 1000) System.out.println(-1);
        else System.out.println(time);
    }

    private static void checkingDuplicate() {
        //상어를 1번 부터 정렬해서 먼저 차지하게 한다.
        for (int sIdx = 1; sIdx <= M; sIdx++) {
            if (!sharks.containsKey(sIdx)) continue;

            Shark shark = sharks.get(sIdx);
            if (map[shark.x][shark.y][0] != 0 && map[shark.x][shark.y][0] < sIdx) {
                sharks.remove(sIdx);
            } else {
                map[shark.x][shark.y][0] = sIdx;
                map[shark.x][shark.y][1] = K;
            }
        }
    }

    private static void reduceEachCellSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j][1] > 0) {
                    map[i][j][1]--;
                    if (map[i][j][1] == 0) map[i][j][0] = 0;
                }
            }
        }
    }

    private static void movedShark() {
        for (Integer sIdx : sharks.keySet()) {
            Shark shark = sharks.get(sIdx);
            shark.movedNext();
        }
    }
}
