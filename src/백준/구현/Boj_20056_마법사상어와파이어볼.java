package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20056_마법사상어와파이어볼 {
    private static class FireBall {
        int r, c;
        int m, s, d;//질량, 방향, 속도
        List<Integer> dirs = new ArrayList<>();
        int duplicate = 1;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
            dirs.add(d);
        }

        @Override
        public String toString() {
            return "FireBall{" +
                    "r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    ", dirs=" + dirs +
                    ", duplicate=" + duplicate +
                    '}';
        }
    }

    public static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static int size;
    private static FireBall[][] map;
    private static final Queue<FireBall> div = new ArrayDeque<>();//이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken()); //격자 사이즈
        int fireBallCnt = Integer.parseInt(st.nextToken()); //파이어볼 개수
        int moveCnt = Integer.parseInt(st.nextToken()); //다 두고 나서 이동하는 수
        map = new FireBall[size][size];

        //m번으 파이어 볼 발사 (범위 넘어가면 그냥 그 만큼 돌아다님)
        for (int i = 0; i < fireBallCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            div.add(new FireBall(r, c, m, s, d));
        }

        //k번 이동
        for (int i = 0; i < moveCnt; i++) {
            move();
//            System.out.println(div);
            addBall();
//            System.out.println(div);
            for (int p = 0; p < size; p++)
                for (int q = 0; q < size; q++)
                    if (map[p][q] != null) {
                        System.out.println(map[p][q]);
                        divide(map[p][q]);
                    }
//            System.out.println(div);
        }

        int sumM = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == null || map[i][j].m == 0) continue;
                if (map[i][j].duplicate >= 2) {
                    sumM += (map[i][j].m / 5) * 4;
                } else sumM += map[i][j].m;
            }
        }
        System.out.println(sumM);
    }

    private static void move() {
        int size = div.size();
        while (size-- > 0) {
            FireBall poll = div.poll();
            div.add(movedEachBall(poll, poll.d, false));
        }
    }

    private static void addBall() { //모든 공을 합침
        while (!div.isEmpty()) {
            FireBall now = div.poll();

            if (map[now.r][now.c] == null) {
                map[now.r][now.c] = now;
            } else {
                map[now.r][now.c].m += now.m;
                map[now.r][now.c].s += now.s;
                map[now.r][now.c].duplicate++;
            }

            map[now.r][now.c].dirs.add(now.d);
        }
    }

    private static void divide(FireBall fireBall) {
//        System.out.println(fireBall);
        int before = fireBall.dirs.get(0);
        boolean isSame = true;
        for (Integer dir : fireBall.dirs) {
            if ((before % 2 != 0 || dir % 2 != 0) && (before % 2 != 1 || dir % 2 != 1)) {
                isSame = false;
                break;
            }
        }

        System.out.println("======"+fireBall.m+" "+fireBall.m/5);
        if (fireBall.m / 5 > 0) {
            if (isSame) {
                for (int i = 0; i < 8; i += 2) {//0,2,4,6
                    //이동
                    div.add(movedEachBall(fireBall, i, true));
                }
            } else {
                for (int i = 1; i < 8; i += 2) {//1,3,5,7
                    div.add(movedEachBall(fireBall, i, true));
                }
            }
        }
    }

    private static FireBall movedEachBall(FireBall fireBall, int dir, boolean isDiv) {
        int divS = (isDiv) ? fireBall.s / fireBall.duplicate : fireBall.s;

        int movedX = (fireBall.r + divS * dirs[dir][0] % size + size) % size;
        int movedY = (fireBall.c + divS * dirs[dir][1] % size + size) % size;

        if (!isDiv) return new FireBall(movedX, movedY, fireBall.m, divS, fireBall.d);
//        if (fireBall.m / 5 == 0) return null;
        return new FireBall(movedX, movedY, fireBall.m / 5, divS, dir);
    }
}