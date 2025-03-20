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

        public Soldier(int i, int r, int c, int h, int w, int k) {
            this.i = i;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.damage = 0;
        }

        public Soldier(int i, int r, int c, int h, int w, int k, int damage) {
            this.i = i;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.damage = damage;
        }

        @Override
        public String toString() {
            return "Soldier{" +
                    "i=" + i +
                    ", r=" + r +
                    ", c=" + c +
                    ", h=" + h +
                    ", w=" + w +
                    ", k=" + k +
                    ", damage=" + damage +
                    '}';
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
            soldiers[i] = new Soldier(i, r, c, h, w, k);
        }


        colored2();
//        printMap();

        for (int i = 0; i < commane; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            //사라진 기사라면 끝
            Soldier nowSoldier = soldiers[index];
            if (nowSoldier.k - nowSoldier.damage <= 0) continue;

            //기사 이동
            Queue<Integer> queue = new LinkedList<>();
            for (int x = 0; x < soldiers[index].h && queue != null; x++) {
                for (int y = 0; y < soldiers[index].w; y++) {
                    int mvX = soldiers[index].r + dirs[direction][0] + x;
                    int mvY = soldiers[index].c + dirs[direction][1] + y;
                    if (mvY >= 0 && mvX >= 0 && mapSize > mvY && mapSize > mvX && map[mvX][mvY][1] != 2) {
                        if (map[mvX][mvY][0] >= 100)
                            queue.add(map[mvX][mvY][0] - 100);
                    } else {
                        queue = null;
                        break;
                    }
                }
            }

            //나 자신도 넘어가지 못하는 상황
            if (queue == null) continue;
            int nvX = soldiers[index].r + dirs[direction][0];
            int nvY = soldiers[index].c + dirs[direction][1];


            List<Soldier> temp = getSoldiers(soldiersSize, index, queue, direction, mapSize);

            if (temp != null) {
                //대결 이미지
                for(int t=temp.size()-1;0<=t;t--){
                    Soldier soldier = temp.get(t);
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
                    soldiers[soldier.i] = soldier;//기존걸로 대체

                }
                //본인도 이동
                soldiers[nowSoldier.i] = new Soldier(nowSoldier.i, nvX, nvY, nowSoldier.h, nowSoldier.w, nowSoldier.k, nowSoldier.damage);
                colored2();
//                printMap();
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
        System.out.println("===========");
        for (Soldier soldier : soldiers) {
            System.out.println(soldier);
        }

        System.out.println("============");
    }

//    private static void colored(int r, int c, int w, int h, int i) {
//        System.out.println("colored(INDEX : " +i+" "+ r + ", " + c + ", " + w + ", " + h + ")");
//        for (int x = 0; x < h; x++) {
//            for (int y = 0; y < w; y++) {
//                int mvX = r + x;
//                int mvY = c + y;
//                if (0 <= mvX && 0 <= mvY && mvX < mapSize && mvY < mapSize)
//                    map[mvX][mvY][0] = i; //유저표시
//            }
//        }
//    }
    //문제의 원인 : 다시 0 으로 채우는 순서 ( 그냥 싹 지우고 다시 채우는것이 좋음)

    private static void colored2() {
        for (int[][] ints : map) {
            for (int[] anInt : ints) {
                anInt[0] = 0;
            }
        }

        for(Soldier soldier : soldiers) {
            if(soldier.k - soldier.damage > 0) {
                for (int x = 0; x < soldier.h; x++) {
                    for (int y = 0; y < soldier.w; y++) {
                        int mvX = soldier.r + x;
                        int mvY = soldier.c + y;
                        if (0 <= mvX && 0 <= mvY && mvX < mapSize && mvY < mapSize)
                            map[mvX][mvY][0] = soldier.i+100; //유저표시
                    }
                }
            }
        }

//        System.out.println("colored(INDEX : " +i+" "+ r + ", " + c + ", " + w + ", " + h + ")");
//        for (int x = 0; x < h; x++) {
//            for (int y = 0; y < w; y++) {
//                int mvX = r + x;
//                int mvY = c + y;
//                if (0 <= mvX && 0 <= mvY && mvX < mapSize && mvY < mapSize)
//                    map[mvX][mvY][0] = i; //유저표시
//            }
//        }
    }

    private static List<Soldier> getSoldiers(int n, int index, Queue<Integer> queue, int direction, int l) {
        List<Soldier> temp = new ArrayList<>();
        boolean[] visitedSoldiers = new boolean[n];
        queue.add(index);
        while (!queue.isEmpty()) {
            Soldier soldier = soldiers[queue.poll()];

            int holdX = soldier.r + dirs[direction][0];
            int holdY = soldier.c + dirs[direction][1];
            if (holdX < 0 || holdY < 0 || l <= holdY || l <= holdX ||!visitedSoldiers[soldier.i] && soldier.i!=index) {
                temp.add(new Soldier(soldier.i, holdX, holdY, soldier.h, soldier.w, soldier.k, soldier.damage));
                visitedSoldiers[soldier.i] = true;
            }else{
                continue;
            }

            for (int x = 0; x < soldier.h; x++) {
                for (int y = 0; y < soldier.w; y++) {
                    int mvX = holdX + x;
                    int mvY = holdY + y;
                    if (mvY < 0 || mvX < 0 || l <= mvY || l <= mvX || map[mvX][mvY][1] == 2) {
                        //벽인 경우 무시한다.
//                        System.out.println("FAIL");
                        return null;
                    } else {
                        //이동한 곳에 다른 군인이 있는 경우
                        if (map[mvX][mvY][0] >= 100) {
                            int next = map[mvX][mvY][0] - 100;
                            if (!visitedSoldiers[next])
                                queue.add(next);
                        }
                    }
                }
            }
        }
        return temp;
    }
}

