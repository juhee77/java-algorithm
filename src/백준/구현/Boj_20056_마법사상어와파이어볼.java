package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_20056_마법사상어와파이어볼 {
    private static class FireBall {
        int r, c;
        int m, s, d; // 질량, 방향, 속도
        boolean isSame = true; // 방향이 모두 같으면 true
        int duplicate = 1; // 현재 좌표에 중첩된 파이어볼 수

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }

    public static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static int size;
    private static FireBall[][] map;
    private static final Queue<FireBall> div = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int fireBallCnt = Integer.parseInt(st.nextToken());
        int moveCnt = Integer.parseInt(st.nextToken());
        map = new FireBall[size][size];

        for (int i = 0; i < fireBallCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            div.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < moveCnt; i++) {
            move(); // 모든 파이어볼 이동
            addBall(); // 파이어볼 병합, 분할
            mergeAndSplitBalls(); // 파이어볼  나누기
        }

        // 남은 파이어볼의 질량 합산
        int sumM = 0;
        for (FireBall fireBall : div) {
            sumM += fireBall.m;
        }
        System.out.println(sumM);
    }

    private static void move() {
        int tempSize = div.size();
        while (tempSize-- > 0) {
            FireBall poll = div.poll();
            int movedX = (poll.r + (poll.s * dirs[poll.d][0]) % size + size) % size;
            int movedY = (poll.c + (poll.s * dirs[poll.d][1]) % size + size) % size;
            poll.r = movedX;
            poll.c = movedY;
            div.add(poll);
        }
    }

    private static void addBall() {
        while (!div.isEmpty()) {
            FireBall now = div.poll();
            if (map[now.r][now.c] == null) {
                map[now.r][now.c] = now;
            } else {
                FireBall preSave = map[now.r][now.c];
                preSave.m += now.m;
                preSave.s += now.s;
                preSave.duplicate++;
                preSave.isSame &= (preSave.d % 2 == now.d % 2);
            }
        }
    }

    private static void mergeAndSplitBalls() {
        for (int p = 0; p < size; p++) {
            for (int q = 0; q < size; q++) {
                if (map[p][q] != null) {
                    if (map[p][q].duplicate > 1) divide(map[p][q]);
                    else div.add(map[p][q]);
                    map[p][q] = null;
                }
            }
        }
    }

    private static void divide(FireBall fireBall) {
        if (fireBall.m / 5 == 0) return;
        int newMass = fireBall.m / 5;
        int newSpeed = fireBall.s / fireBall.duplicate;
        int startDir = fireBall.isSame ? 0 : 1;
        for (int i = 0; i < 8; i += 2) {
            div.add(new FireBall(fireBall.r, fireBall.c, newMass, newSpeed, startDir + i));
        }
    }
}
