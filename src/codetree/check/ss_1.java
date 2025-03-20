package codetree.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ss_1 {
    private static int mapSize;
    private static final int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static class Soldier {
        int i;
        int r;
        int c;
        int h;
        int w;
        int k;
        int damage;

        public Soldier(int i, int r, int c, int h, int w, int k, int damage) {
            this.i = i;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.damage = damage;
        }
    }

    private static Soldier[] soldiers;
    private static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSize = Integer.parseInt(st.nextToken());
        int soldiersSize = Integer.parseInt(st.nextToken());
        int commane = Integer.parseInt(st.nextToken());

        soldiers = new Soldier[soldiersSize];
        map = new int[mapSize][mapSize][2];//사람, 지도

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j][1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < soldiersSize; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            soldiers[i] = new Soldier(i, r, c, h, w, k, 0);
            colored(r, c, w, h, 100 + i);
        }


        // printMap();

        for (int i = 0; i < commane; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            // 자신의 이동을 먼저 검사
            boolean canMove = true;
            for (int x = 0; x < soldiers[index].h; x++) {
                for (int y = 0; y < soldiers[index].w; y++) {
                    int mvX = soldiers[index].r + dirs[direction][0] + x;
                    int mvY = soldiers[index].c + dirs[direction][1] + y;

                    // 벽에 부딪히면 이동 불가
                    if (mvY < 0 || mvX < 0 || mvX >= mapSize || mvY >= mapSize || map[mvX][mvY][1] == 2) {
                        canMove = false;
                        break;
                    }
                }
                if (!canMove) break;
            }

// 벽에 부딪히면 자신도 이동할 수 없다.
            if (!canMove) continue; // 자신이 이동할 수 없다면 다음 명령으로 넘어간다.

// 이제 이동할 수 있을 경우, queue에 다른 군인들만 이동하도록 처리
            Queue<Integer> queue = new LinkedList<>();
            for (int x = 0; x < soldiers[index].h; x++) {
                for (int y = 0; y < soldiers[index].w; y++) {
                    int mvX = soldiers[index].r + dirs[direction][0] + x;
                    int mvY = soldiers[index].c + dirs[direction][1] + y;

                    if (mvY >= 0 && mvX >= 0 && mvX < mapSize && mvY < mapSize && map[mvX][mvY][1] != 2) {
                        if (map[mvX][mvY][0] >= 100) { // 다른 군인들 확인
                            queue.add(map[mvX][mvY][0] - 100); // 군인에 해당하는 ID로 처리
                        }
                    } else {
                        queue = null; // 벽이나 이동 불가로 인해 더 이상 이동 불가
                        break;
                    }
                }
            }

// queue가 비어있거나 null일 경우 이동할 수 없다.
            if (queue == null || queue.isEmpty()) continue; // 군인이 이동할 수 없는 경우

            List<Soldier> temp = getSoldiers(soldiersSize, queue, direction);

            //연관 해서 이동하다가 벽에 만나는 경우
            if (temp != null) {
                //대결 이미지
                for (Soldier soldier : temp) {
                    //함정의 수만큼 피해
                    int damage = 0;
                    for (int x = 0; x < soldier.h; x++) {
                        for (int y = 0; y < soldier.w; y++) {
                            int mvX = soldier.r + x;
                            int mvY = soldier.c + y;
                            if (0 <= mvX && 0 <= mvY && mvX < mapSize && mvY < mapSize && map[mvX][mvY][1] == 1) {
                                damage++;
                            }
                        }
                    }
                    soldier.damage += damage;

                    //원래 군인
                    Soldier original = soldiers[soldier.i];
                    colored(original.r, original.c, original.w, original.h, 0);

                    //생존된 기사인지 확인
                    if (soldier.k - soldier.damage >= 0) {
                        colored(soldier.r, soldier.c, soldier.w, soldier.h, 100 + soldier.i);
                    }
                    soldiers[soldier.i] = soldier; //기존걸로 대체
                }

                //본인도 이동
                Soldier nowSoldier = soldiers[index];
                colored(nowSoldier.r, nowSoldier.c, nowSoldier.w, nowSoldier.h, 0);
                colored(nowSoldier.r + dirs[direction][0], nowSoldier.c + dirs[direction][1], nowSoldier.w, nowSoldier.h, 100 + nowSoldier.i);
                soldiers[nowSoldier.i] = new Soldier(nowSoldier.i, nowSoldier.r + dirs[direction][0], nowSoldier.c + dirs[direction][1], nowSoldier.h, nowSoldier.w, nowSoldier.k, nowSoldier.damage);
                // printMap();
                // printMap2();

            }
        }

        long ans = 0;
        for (Soldier soldier : soldiers) {
            if (soldier.k - soldier.damage > 0) {
                ans += soldier.damage;
            }
        }
        System.out.println(ans);

    }

    private static void printMap() {
        for (int[][] ints : map) {
            for (int[] anInt : ints) {
                System.out.print(anInt[0] + " ");
            }
            System.out.println();
        }
    }

    private static void printMap2() {
        System.out.println("ERROR");
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.damage);
        }
    }

    private static void colored(int r, int c, int w, int h, int i) {
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                int mvX = r + x;
                int mvY = c + y;
                if (0 <= mvX && 0 <= mvY && mvX < mapSize && mvY < mapSize)
                    map[mvX][mvY][0] = i; //유저표시
            }
        }
    }

    private static List<Soldier> getSoldiers(int n, Queue<Integer> queue, int direction) {
        List<Soldier> temp = new ArrayList<>();
        boolean[] visitedSoldiers = new boolean[n];

        while (!queue.isEmpty()) {
            Soldier soldier = soldiers[queue.poll()];

            int holdX = soldier.r + dirs[direction][0];
            int holdY = soldier.c + dirs[direction][1];
            if (holdX < 0 || holdY < 0 || mapSize <= holdY || mapSize <= holdX || !visitedSoldiers[soldier.i] ||
                    soldier.k >= soldier.damage) {
                temp.add(new Soldier(soldier.i, holdX, holdY, soldier.h, soldier.w, soldier.k, soldier.damage));
                visitedSoldiers[soldier.i] = true;
            } else {
                continue;
            }

            //이동한 곳에서의 영역에 다른 사람이 있는지 확인
            for (int x = 0; x < soldier.h; x++) {
                for (int y = 0; y < soldier.w; y++) {
                    int mvX = holdX + x;
                    int mvY = holdY + y;
                    if (mvY < 0 || mvX < 0 || mapSize <= mvY || mapSize <= mvX || map[mvX][mvY][1] == 2) {
                        //벽인 경우 모두 이동하지 않는다.
                        // System.out.println("FAIL");
                        return null;
                    } else {
                        //이동한 곳에 다른 군인이 있는 경우
                        if (map[mvX][mvY][0] >= 100) {
                            int next = map[mvX][mvY][0] - 100;
                            if (!visitedSoldiers[next]) {
                                queue.add(next);
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }
}
