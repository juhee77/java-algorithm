package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16985_Maaaaaaze {
    private static boolean[][][][] map = new boolean[5][4][5][5]; //판의 수, 4방위
    private static boolean[] visited = new boolean[5];
    private static int[] mazeCase = new int[5]; //판의 가능 조합
    private static int[][] mazeCaseDir = new int[1024][5]; //판의 가능 조합의 방향
    private static int[] tempDir = new int[5]; //판의 가능 조합의 방향
    private static int[][] dir = {{0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}};//x,y,z
    private static int cs = 0;
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            for (int p = 0; p < 5; p++) {
                st = new StringTokenizer(br.readLine());
                for (int q = 0; q < 5; q++) {
                    map[i][0][p][q] = Integer.parseInt(st.nextToken()) != 0;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                rotation(i, j);
            }
        }
        //모든 방향 조합 계산
        findDirectionalCase(0);
        //모든 층의 조합 계산후 최단 거리 구함
        findFloorCase(0);
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void findFloorCase(int nowD) {
        if (nowD == 5) {
            findMinRoad();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                mazeCase[nowD] = i;
                visited[i] = true;

                findFloorCase(nowD + 1);
                visited[i] = false;
            }
        }
    }

    private static void findMinRoad() {
        //case에 층의 조합 {4,3,2,1,0} 인 경우 마지막 칸이 제일 위에 온경우
        //dir에 모든 경우의 수(이만큼 확인 해야함
        for (int[] nowRot : mazeCaseDir) {
            if (map[mazeCase[0]][nowRot[0]][0][0] && map[mazeCase[4]][nowRot[4]][4][4]) { //출발, 끝은 사람이 갈수 있는 곳이여야 한다.
                boolean[][][] nowMap = new boolean[5][5][5];
                for (int p = 0; p < 5; p++) {
                    nowMap[p] = map[mazeCase[p]][nowRot[p]];
                }
                findMin(nowMap);
            }
        }
    }

    private static void findMin(boolean[][][] nowMap) {
        Queue<Point> queue = new LinkedList<>();
        int[][][] visited = new int[5][5][5];

        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = 1; // 일단 출발점은 1부터 라고 생각함

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == 4 && now.y == 4 && now.z == 4) {
                min = Math.min(min, visited[4][4][4] - 1);
            }

            for (int i = 0; i < 6; i++) {
                int mvx = now.x + dir[i][0];
                int mvy = now.y + dir[i][1];
                int mvz = now.z + dir[i][2];
                if (mvx < 0 || mvy < 0 || mvz < 0 || 5 <= mvx || 5 <= mvy || 5 <= mvz) continue;
                if (!nowMap[mvx][mvy][mvz]) continue;//불가능한
                if (visited[mvx][mvy][mvz] != 0) continue;//이미 방문함.
                visited[mvx][mvy][mvz] = visited[now.x][now.y][now.z] + 1;
                queue.add(new Point(mvx, mvy, mvz));
            }
        }
    }

    private static void findDirectionalCase(int nowD) {
        //정해진 5개의 층을 어떻게 회전시킬지.
        if (nowD == 5) {
            mazeCaseDir[cs++] = tempDir.clone();
            return;
        }
        for (int i = 0; i < 4; i++) {
            tempDir[nowD] = i;
            findDirectionalCase(nowD + 1);
        }

    }

    //시계방향으로 회전, floor은 현재 회전하는 판의 번호, direction은 시계방향으로 몇번 돌렸는지.
    private static void rotation(int floor, int direction) {
        //시계 방향 회전은 (x,y)->(y,4-x)->(4-x,4-y)->(4-y,x);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[floor][direction - 1][i][j]) {
                    map[floor][direction][j][4 - i] = true;
                }
            }
        }
    }

    private static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
