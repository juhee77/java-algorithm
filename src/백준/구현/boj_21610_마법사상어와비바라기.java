package 백준.구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_21610_마법사상어와비바라기 {
    private static final ArrayList<Point> cloud = new ArrayList<>();
    private static final ArrayList<Integer> saveWater = new ArrayList<>();
    private static final int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int cmd = Integer.parseInt(st.nextToken());

        /*init*/
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud.add(new Point(size - 1, 0));
        cloud.add(new Point(size - 1, 1));
        cloud.add(new Point(size - 2, 0));
        cloud.add(new Point(size - 2, 1));

        // 실행
        while (cmd-- > 0) {
            st = new StringTokenizer(br.readLine());
            int nowCmd = Integer.parseInt(st.nextToken()) - 1;
            int movedCnt = Integer.parseInt(st.nextToken()) % size;
            int[] nowDir = dir[nowCmd];

            //구름 이동
            for (int i = 0; i < cloud.size(); i++) {
                Point now = cloud.get(i);
                int mvx = check(size, now.x + nowDir[0] * movedCnt);
                int mvy = check(size, now.y + nowDir[1] * movedCnt);

                cloud.set(i, new Point(mvx, mvy));
            }

            boolean[][] visited = new boolean[size][size]; //구름이 있던 칸 저장

            //구름 칸에 비 내린다
            for (Point now : cloud) {
                map[now.x][now.y]++;
                visited[now.x][now.y] = true;
            }

            for (Point now : cloud) {
                // 물복사 버그 마법을 시전한다.
                int[] cross = {1, 3, 5, 7};
                int water = 0;
                for (int e : cross) {
                    int[] dirCross = dir[e];
                    int mvx = now.x + dirCross[0];
                    int mvy = now.y + dirCross[1];
                    if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy) continue;
                    if (map[mvx][mvy] > 0) water++;
                }
                saveWater.add(water);
            }

            //복사한 물 저장
            for (int i = 0; i < cloud.size(); i++) {
                Point now = cloud.get(i);
                map[now.x][now.y] += saveWater.get(i);
            }

            //구름이 모두 사라진다
            cloud.clear();
            saveWater.clear();

            //2이상인 칸 찾기
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (visited[i][j]) continue;
                    if (map[i][j] >= 2) {
                        cloud.add(new Point(i, j));
                        map[i][j] -= 2;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    private static int check(int size, int nowPoint) {
        if (size <= nowPoint) {
            return nowPoint % size;
        }
        if (nowPoint < 0) {
            return nowPoint + size;
        }
        return nowPoint;
    }
}
