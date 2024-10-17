package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Save_6 {
    private static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][][] mArr;
    private static boolean[][][] vmArr;
    private static int[][] arr;
    private static boolean[][] vArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        vArr = new boolean[n][n];
        int mC = -1, mR = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 3 && mR == -1) {
                    mR = i;
                    mC = j;
                }
            }
        }

        mArr = new int[5][m][m];
        vmArr = new boolean[5][m][m];
        int sSX = 0, sSY = 0;
        //동 서 남 북 위
        // 배열 순서는 동 남 서 북 위
        for (int i = 0; i < 5; i++) {
            int hold = i;
            if (hold == 1 || i == 2) hold = (hold == 1) ? 2 : 1;
            for (int p = 0; p < m; p++) {
                st = new StringTokenizer(br.readLine());
                for (int q = 0; q < m; q++) {
                    mArr[hold][p][q] = Integer.parseInt(st.nextToken());
                    if (mArr[hold][p][q] == 2) {
                        sSX = p;
                        sSY = q;
                    }
                }
            }

        }

        //산에서의 탈출 구멍 색칙
        boolean isRoot = false;
        int startX = -1, startY = -1;
        for (int i = 0; i < m; i++) {
            if (arr[mR - 1][mC + i] == 0) { //북
//                System.out.println("북쪽 출구");
                mArr[3][m - 1][m - i - 1] = 4;
                startX = mR - 1;
                startY = mC + i;
                isRoot = true;
                break;
            }
            if (arr[mR + i][mC + m] == 0) { //동
//                System.out.println("동쪽 출구");
                mArr[0][m - 1][m - i - 1] = 4;
                startX = mR + i;
                startY = mC + m;
                isRoot = true;
                break;
            }
            if (arr[mR + i][mC - 1] == 0) { //서
//                System.out.println("서쪽 출구");
                mArr[2][m - 1][i] = 4;
                startX = mR + i;
                startY = mC - 1;
                isRoot = true;
                break;
            }
            if (arr[mR + m][mC + i] == 0) { //남
//                System.out.println("남쪽 출구");
                mArr[1][m - 1][i] = 4;
                startX = mR + m;
                startY = mC + i;
                isRoot = true;
                break;
            }
        }

        if (!isRoot) {
            System.out.println("-1");
            return;
        } else {
            Queue<int[]> fires = new ArrayDeque<>();
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[r][c] = -1; //fire
                fires.add(new int[]{r, c, d, v});
            }

            int turn = 0;
            isRoot = false;
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{4, sSX, sSY});
            //산부터 탐색
            while (!q.isEmpty()) {
                turn++;
                moveFire(n, arr, fires, turn);
                if (isRoot = findMRoot(m, q)) break;
            }

//            System.out.println("[[[[[[산탈출 ]]]]] " + turn);
//            System.out.println("startX = " + startX);
//            System.out.println("startY = " + startY);
//            System.out.println("arr[startX][startY] = " + arr[startX][startY]);
            if (arr[startX][startY] != 0 || !isRoot) {
                System.out.println(-1);
                return;
            } else {
                //이제 땅 탕출
                q.clear();
                isRoot = false;
                q.add(new int[]{startX, startY});
                vArr[startX][startY] = true;
                while (!q.isEmpty()) {
                    turn++;
                    moveFire(n, arr, fires, turn);
                    if (isRoot = findCRoot(n, q)) break;
                }
            }
            System.out.println(isRoot ? turn - 1 : -1);

        }
    }

    private static boolean findCRoot(int m, Queue<int[]> q) {
        int size = q.size();
        while (size-- > 0) {
            int[] poll = q.poll();
//            System.out.println(Arrays.toString(poll));
            if (arr[poll[0]][poll[1]] == 4) {
                return true;
            }

            for (int[] dir : dirs) {
                int mvX = dir[0] + poll[0];
                int mvY = dir[1] + poll[1];

                if (mvX < 0 || mvY < 0 || m <= mvX || m <= mvY) continue;
                if ((arr[mvX][mvY] == 0 || arr[mvX][mvY] == 4) && !vArr[mvX][mvY]) {
                    vArr[mvX][mvY] = true;
                    if (arr[mvX][mvY] != 4) arr[mvX][mvY] = 100;
                    q.add(new int[]{mvX, mvY});
                }
            }
        }
        return false;
    }

    private static boolean findMRoot(int m, Queue<int[]> q) {
        int size = q.size();
        for (int s = 0; s < size; s++) {
            int[] poll = q.poll(); //dir, x, y
            if (mArr[poll[0]][poll[1]][poll[2]] == 4) {
//                System.out.println("찾았다 출구 : " + Arrays.toString(poll));
                return true;
            }

            for (int[] dir : dirs) {
                int mvX = poll[1] + dir[0];
                int mvY = poll[2] + dir[1];
                int mvD = poll[0];
                if (mvY < 0 || mvX < 0 || m <= mvX || m <= mvY) {
                    if (mvD == 4) {
                        if (mvX == -1) { //N
                            mvD = 3;
                            mvY = m - 1 - mvY;
                            mvX = 0;
                        } else if (mvX == m) { // S
                            mvD = 1;
                            mvX = 0;
                        } else if (mvY == -1) { // W
                            mvD = 2;
                            mvY = mvX;
                            mvX = 0;
                        } else if (mvY == m) { //E
                            mvD = 0;
                            mvY = m - 1 - mvX;
                            mvX = 0;
                        }
                    } else {
                        if (mvY == -1) {
                            mvD = mvD + 1 == 4 ? 0 : mvD + 1;
                            mvY = m - 1;
                        } else if (mvY == m) {
                            mvD = mvD - 1 == -1 ? 3 : mvD - 1;
                            mvY = 0;
                        } else if (mvX == -1) {
                            if (mvD == 0) {
                                mvD = 4;
                                mvX = m - 1 - mvY;
                                mvY = m - 1;
                            } else if (mvD == 1) {
                                mvD = 4;
                                mvX = m - 1;
                            } else if (mvD == 2) {
                                mvD = 4;
                                mvX = mvY;
                                mvY = m - 1;
                            } else if (mvD == 3) {
                                mvD = 4;
                                mvY = m - 1 - mvY;
                                mvX = 0;
                            }
                        }
                    }
                }


//                System.out.println("이동ㅣ " + mvD + " " + mvX + " " + mvY);
                if (mvX < 0 || mvY < 0 || m <= mvX || m <= mvY) continue;
                if ((mArr[mvD][mvX][mvY] == 0 || mArr[mvD][mvX][mvY] == 4) && !vmArr[mvD][mvX][mvY]) {
                    vmArr[mvD][mvX][mvY] = true;
                    q.add(new int[]{mvD, mvX, mvY});
                }
            }
        }
        return false;
    }

    private static void moveFire(int m, int[][] arr, Queue<int[]> fires, int turn) {
        int size = fires.size();
        for (int tempF = 0; tempF < size; tempF++) {
            int[] fire = fires.poll();
            if (turn % fire[3] == 0) {
                int mvX = fire[0] + dirs[fire[2]][0];
                int mvY = fire[1] + dirs[fire[2]][1];
//                System.out.println("불이 다음칸에 번진다:" + mvX + " " + mvY);
                if (mvX < 0 || mvY < 0 || m <= mvX || m <= mvY || arr[mvX][mvY] != 0) continue;
                arr[mvX][mvY] = -1;
                fires.add(new int[]{mvX, mvY, fire[2], fire[3]});
            } else {
                fires.add(fire);
            }
        }


//        System.out.println("TURN : " + turn);
//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println();
    }

}
