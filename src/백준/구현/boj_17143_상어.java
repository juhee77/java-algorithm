package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17143_상어 {
    private static class Shark {
        public int velocity;
        public int dir;
        public int weight;

        public Shark(int velocity, int dir, int weight) {
            this.velocity = velocity;
            this.dir = dir;
            this.weight = weight;
        }
    }

    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Shark[][] map = new Shark[R][C];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) ;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(s, d, z);
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        //사람이 이동한다.
        long sum = 0;
        for (int i = 0; i < C; i++) {
            //1 상어 잡기
            for (int j = 0; j < R; j++) {
                if (map[j][i] != null) {
                    sum += map[j][i].weight;
                    map[j][i] = null;
                    break;
                }
            }


            //2 상어들 이동
            Shark[][] temp = new Shark[R][C];
            for (int p = 0; p < R; p++) {
                for (int q = 0; q < C; q++) {
                    if (map[p][q] != null) {
                        Shark shark = map[p][q];
                        int[] mv = null;
                        switch (map[p][q].dir) {
                            case 1:
                            case 2://위쪽 아래:
                                mv = findNextRowLocal(p, q, shark);
                                break;
                            case 3:
                            case 4://왼 dh
                                mv = findNextColLocal(p, q, shark);
                                break;
                        }

                        if (temp[mv[0]][mv[1]] == null) {
                            temp[mv[0]][mv[1]] = shark;
                        } else if (temp[mv[0]][mv[1]].weight < shark.weight) { //더 무거운 상어로 바꾼다
                            temp[mv[0]][mv[1]] = shark;
                        }
                    }
                }
            }
            map = temp;
        }

        System.out.println(sum);

    }

    private static int[] findNextRowLocal(int i, int j, Shark shark) {//위 아래
        int next = (shark.dir == 1) ? i - shark.velocity : i + shark.velocity; // 1인 경우 위쪽, 2인 경우 아래쪽
        if (next <= 0 || R - 1 <= next) {
            next = Math.abs(next);
            next %= (2 * R - 2); //한바퀴를 도는 경우 현재 상태와 일치하기떄문에
            if (next < R) {
                shark.dir = 2; //아래쪽
            } else {
                next = (2 * R - next - 2);
                shark.dir = 1; //위쪽(한 바퀴를 넘어가서)
            }

        }

        return new int[]{next, j};
    }


    private static int[] findNextColLocal(int i, int j, Shark shark) { //오 왼
        int next = (shark.dir == 4) ? j - shark.velocity : j + shark.velocity; //3인경우 오른쪽, 4인경우 외쪽
        if (next <= 0 || C - 1 <= next) {
            next = Math.abs(next);
            next %= (2 * C - 2); //한바퀴를 도는 경우 현재 상태와 일치하기떄문에
            if (next < C) {
                shark.dir = 3; //오른쪽
            } else {
                next = (2 * C - next - 2);
                shark.dir = 4; //왼쪽(한바퀴를 넘어감)
            }
        }

        return new int[]{i, next};
    }
}
