package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17135_캐슬디펜스 {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Enemy cpyEnemy) {
            return Math.abs(x - cpyEnemy.x) + Math.abs(y - cpyEnemy.y);
        }
    }

    private static class Enemy extends Point {
        boolean isDie = false;

        public Enemy(int x, int y) {
            super(x, y);
        }
    }

    private static int enemyCnt;
    private static int N, M, D; //행,열
    private static List<Enemy> enemies = new ArrayList<>();
    private static int maxDie = 0;
    private static int[] solider = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    enemies.add(new Enemy(i, j));
                    enemyCnt++;
                }
            }
        }

        findMaxCase(0, 0);
        System.out.println(maxDie);
    }

    private static void findMaxCase(int nowDepth, int start) {
        if (maxDie == enemyCnt) return;

        if (nowDepth == 3) {
            List<Point> soliders = new ArrayList<>();

            for (int i : solider) {
                soliders.add(new Point(N, i));
            }

            playGame(soliders);
        } else {
            for (int i = start; i < M && maxDie < enemyCnt; i++) {
                solider[nowDepth] = i;
                findMaxCase(nowDepth + 1, i + 1);
            }
        }

    }

    private static void playGame(List<Point> soliders) {
        //setting enemy
        LinkedList<Enemy> nowGameEnemy = new LinkedList<>();
        for (Enemy enemy : enemies) {
            nowGameEnemy.add(new Enemy(enemy.x, enemy.y));
        }

        int dieCnt = 0;
        while (!nowGameEnemy.isEmpty()) {
            Enemy[] minEnemy = new Enemy[3];
            int[] minDistance = {D, D, D};
            //System.out.println("BEFORE "+nowGameEnemy);

            int cc = 0;
            while (cc < nowGameEnemy.size()) {
                Enemy tempEnemy = nowGameEnemy.get(cc);
                //3명의 궁수와 길이 비교
                if (tempEnemy.isDie) {
                    nowGameEnemy.remove(cc);
                    dieCnt++;
                    continue;
                }
                if (tempEnemy.x == N) {
                    nowGameEnemy.remove(cc);
                    continue; //성을 통과함
                }

                for (int i = 0; i < 3; i++) {
                    Point nowSolider = soliders.get(i);
                    int distance = nowSolider.getDistance(tempEnemy);
                    if (distance < minDistance[i] ||
                            (minEnemy[i] == null && distance <= minDistance[i])
                            || (distance == minDistance[i] && tempEnemy.y < minEnemy[i].y)) {
                        minEnemy[i] = tempEnemy;
                        minDistance[i] = distance;
                    }
                }
                cc++;
                tempEnemy.x += 1; //한칸 이동시킴
            }

            for (Enemy enemy : minEnemy) {
                if (enemy == null) continue;
                enemy.isDie = true;
            }
        }
        maxDie = Math.max(maxDie, dieCnt);
    }
}
