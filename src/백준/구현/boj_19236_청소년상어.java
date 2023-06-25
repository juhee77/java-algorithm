package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_19236_청소년상어 {
    private static final int[][] dirs = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    private static int maxScore = 0;

    private static class Fish {
        int index;
        int dirIndex;
        int x, y;

        public Fish(Fish fish) {
            this.index = fish.index;
            this.dirIndex = fish.dirIndex;
            this.x = fish.x;
            this.y = fish.y;
        }

        public Fish(int index, int dirIndex, int x, int y) {
            this.index = index;
            this.dirIndex = dirIndex;
            this.x = x;
            this.y = y;
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Fish[][] fishArr = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int index = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishArr[i][j] = new Fish(index, dir, i, j);
            }
        }


        Fish fish = fishArr[0][0];
        fishArr[0][0] = null;
        dfs(fishArr, 0, 0, fish.index, fish.dirIndex);
        System.out.println(maxScore);
    }


    public static void dfs(Fish[][] fishArr, int sX, int sY, int score, int dir) {

        maxScore = Math.max(maxScore, score);

        //물고기가 이동한다.
        List<Fish> fishPoll = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (fishArr[i][j] != null) {
                    fishPoll.add(fishArr[i][j]);
                }
            }
        }

        fishPoll.sort(Comparator.comparingInt(o -> o.index)); // 물고기는 순서대로 움직인다.
        for (Fish fish : fishPoll) {
            int fX = fish.x;
            int fY = fish.y;
            int fD = fish.dirIndex;

            boolean find = false;
            int swapX = -1, swapY = -1;
            for (int i = fD; i < fD + 8 && !find; i++) {
                int[] tempDir = dirs[i % 8];
                int mvX = fX + tempDir[0];
                int mvY = fY + tempDir[1];
                if (mvX < 0 || mvY < 0 || 4 <= mvY || 4 <= mvX) continue; //범위를 넘어감
                if (mvX == sX && mvY == sY) continue; //상어가 있다.
                find = true;
                swapX = mvX;
                swapY = mvY;
                fish.dirIndex = i % 8; //물고기 방향이 바뀜 //이걸 안해서 고생고생 개고생..
            }

            //물고기가 이동할 수 있는 방향을 찾는다 이동 시킨다.
            if (find) {
                if (fishArr[swapX][swapY] != null) {
                    Fish swappedFish = fishArr[swapX][swapY];
                    swappedFish.set(fX, fY);
                    fish.set(swapX, swapY);

                    fishArr[swapX][swapY] = fish;
                    fishArr[fX][fY] = swappedFish;


                } else {// 빈칸인 경우!
                    fish.set(swapX, swapY);
                    fishArr[swapX][swapY] = fish;
                    fishArr[fX][fY] = null;
                }
            }
        }

        //상어가 먹을 수 있는 물고기 마다 확인한다.
        int[] sharkDir = dirs[dir];
        while (true) {
            sX += sharkDir[0];
            sY += sharkDir[1];

            if (sX < 0 || sY < 0 || 4 <= sX || 4 <= sY) break;//범위를 벗어남
            if (fishArr[sX][sY] == null) continue; //빈칸이다.

            //해당 물고기를 먹는다면
            Fish eatenFish = fishArr[sX][sY];
            fishArr[sX][sY] = null;

            dfs(cloneArr(fishArr), sX, sY, score + eatenFish.index, eatenFish.dirIndex);

            fishArr[sX][sY] = eatenFish;






        }

    }

    private static Fish[][] cloneArr(Fish[][] fishArr) {
        Fish[][] cloneArr = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Fish fish = fishArr[i][j];
                if (fish != null)
                    cloneArr[i][j] = new Fish(fish);
            }
        }
        return cloneArr;
    }
}
