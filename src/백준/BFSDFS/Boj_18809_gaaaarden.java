package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Boj_18809_gaaaarden {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int n, m;
    private static int g, r;
    private static ArrayList<Point> points = new ArrayList<>(); //둘 수 있는곳
    private static int[][] map;
    private static int[] pointsMap;
    private static int maxFlower =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        map = new int[n][m];

        //0호수 1 배양액 불가능 2 배양액 가능
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    points.add(new Point(i, j));
                }
            }
        }


        pointsMap = new int[points.size()];
        selectLand(0, 0, 1);

        System.out.println(maxFlower);
    }

    public static void selectLand(int start, int nowDepth, int color) {
        if ((color==1 &&nowDepth == g) || (color==2&&nowDepth==r)) {
//            System.out.println(color+" "+Arrays.toString(pointsMap));

            if (color == 2) {
                //얼마나 꽃을 피울 수 있는가
                findMaxFlower();
            } else {
                //빨간색 선택
                selectLand(0, 0, 2);
            }
        }

        for (int i = start; i < points.size(); i++) {
            if (pointsMap[i] != 0) continue;

            pointsMap[i] = color;
            selectLand(i + 1, nowDepth + 1, color);
            pointsMap[i] = 0;
        }
    }

    private static void findMaxFlower() {
        int flowerCnt = 0;
        int[][] cpyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            cpyMap[i] = map[i].clone();
        }

        Queue<Point> red = new LinkedList<>();
        Queue<Point> green = new LinkedList<>();

        for (int i = 0; i < pointsMap.length; i++) {
            Point nowLane = points.get(i);
            if (pointsMap[i] == 1) {
                green.add(nowLane);
                cpyMap[nowLane.x][nowLane.y] = 3; //초록
            } else if (pointsMap[i] == 2) {
                red.add(nowLane);
                cpyMap[nowLane.x][nowLane.y] = 4; //빨강
            }
        }


        int depth = 5;
        while (!red.isEmpty() && !green.isEmpty()) {
            //초록색 먼저 움직인다.
            int size = green.size();
            for (int i = 0; i < size; i++) {
                Point now = green.poll();
                if(cpyMap[now.x][now.y]==-1)continue;//꽃이 핌

                for (int[] dir : dirs) {
                    int mvx = now.x + dir[0];
                    int mvy = now.y + dir[1];

                    if (mvx < 0 || mvy < 0 || n <= mvx || m <= mvy) {
                        continue;
                    }
                    if (cpyMap[mvx][mvy] == 1 || cpyMap[mvx][mvy] == 2) {
                        green.add(new Point(mvx, mvy));
                        cpyMap[mvx][mvy] = depth;
                    }
                }
            }

            depth++;//빨간색
            size = red.size();
            for (int i = 0; i < size; i++) {
                Point now = red.poll();
                for (int[] dir : dirs) {
                    int mvx = now.x + dir[0];
                    int mvy = now.y + dir[1];

                    if (mvx < 0 || mvy < 0 || n <= mvx || m <= mvy) {
                        continue;
                    }

                    if (cpyMap[mvx][mvy] == 1 || cpyMap[mvx][mvy] == 2) {
                        red.add(new Point(mvx, mvy));
                        cpyMap[mvx][mvy] = depth;
                    } else if (cpyMap[mvx][mvy] == depth - 1) {//꽃이 피어지는 순간
                        flowerCnt++;
                        cpyMap[mvx][mvy] = -1;
                    }
                }
            }
            depth++;
        }

        maxFlower =Math.max(maxFlower, flowerCnt);
    }

}
