package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_21609_상어중학교 {
    private static int size, colorCnt;
    private static int[][] arr;
    private static boolean[][] visited;
    private static PriorityQueue<Blocks> blocks = new PriorityQueue<>();
    private static final int DELETED = -100;
    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static class Blocks implements Comparable<Blocks> {
        int color;
        int rainbowCnt;
        int blockCnt;
        int row, col;

        public Blocks(int color, int rainbowColor, int blockColorCnt, int row, int col) {
            this.color = color;
            this.rainbowCnt = rainbowColor;
            this.blockCnt = blockColorCnt;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Blocks o) {
            int oTotalCnt = o.blockCnt + o.rainbowCnt;
            int totalCnt = blockCnt + rainbowCnt;
            if (oTotalCnt == totalCnt) {
                if (o.rainbowCnt == rainbowCnt) {
                    if (o.row == row) {
                        return o.col - col;
                    }
                    return o.row - row;
                }
                return o.rainbowCnt - rainbowCnt;
            }

            return oTotalCnt - totalCnt;
        }

        @Override
        public String toString() {
            return "Blocks [color=" + color + ", rainbowColor=" + rainbowCnt + ", blockCnt=" + blockCnt + ", row="
                    + row + ", col=" + col + "]";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        colorCnt = Integer.parseInt(st.nextToken());

        arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cost = 0;
        while (true) {
            blocks = new PriorityQueue<Blocks>();
            visited = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (visited[i][j] || arr[i][j] <= 0 || arr[i][j] == DELETED)
                        continue;
                    findBlocks(i, j);
                }
            }

            if (blocks.isEmpty()) break;

            Blocks start = blocks.poll();
            int score = start.blockCnt + start.rainbowCnt;
            cost += score * score;
            deleteBlock(start);
            gravity();
            arr = rotation(arr);
            gravity();
        }
        System.out.print(cost);
    }

    private static void deleteBlock(Blocks start) {
        visited = new boolean[size][size];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start.row, start.col});
        visited[start.row][start.col] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int mvX = poll[0] + dir[0];
                int mvY = poll[1] + dir[1];

                if (mvX < 0 || mvY < 0 || size <= mvX || size <= mvY || visited[mvX][mvY] || arr[mvX][mvY] < 0)
                    continue;
                if (arr[mvX][mvY] != arr[start.row][start.col] && arr[mvX][mvY] != 0)
                    continue;
                visited[mvX][mvY] = true;
                arr[mvX][mvY] = DELETED;
                queue.add(new int[]{mvX, mvY});
            }
        }
        arr[start.row][start.col] = DELETED;
    }

    private static int[][] rotation(int[][] temp) {
        int[][] cpyArr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cpyArr[i][j] = temp[j][size - 1 - i];
            }
        }

        return cpyArr;
    }

    private static void gravity() {
        for (int i = 0; i < size; i++) {
            int hold = size - 1;

            for (int j = size - 1; 0 <= j; j--) {
                if (arr[j][i] == -1)
                    hold = j - 1;
                else if (arr[j][i] != DELETED) {
                    arr[hold][i] = arr[j][i];
                    if (hold != j)
                        arr[j][i] = DELETED;
                    hold--;
                }
            }
        }
    }

    private static void findBlocks(int i, int j) {
        boolean[][] rainbowVisit = new boolean[size][size];
        int cnt = 0;
        int rainBowCnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        visited[i][j] = true;
        cnt++;

        // 무지개 블록으로 시작하는 경우, 무지개 블록이 하나 껴있는경우
//		int tc = 0;
        while (!queue.isEmpty()) {
//			if (10 < tc++)
//				break;

            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int mvX = poll[0] + dir[0];
                int mvY = poll[1] + dir[1];
//				System.out.println(mvX + " " + mvY);

                if (mvX < 0 || mvY < 0 || size <= mvX || size <= mvY || visited[mvX][mvY] || arr[mvX][mvY] < 0
                        || rainbowVisit[mvX][mvY])
                    continue;

                if (arr[mvX][mvY] == 0) {
                    rainBowCnt++;
                    rainbowVisit[mvX][mvY] = true;
                } else {
                    if (arr[mvX][mvY] == arr[i][j]) {
                        cnt++;
                        visited[mvX][mvY] = true;
                    } else {
                        continue;
                    }
                }
                queue.add(new int[]{mvX, mvY});
            }
        }

        if (rainBowCnt + cnt < 2)
            return;
        blocks.add(new Blocks(arr[i][j], rainBowCnt, cnt, i, j));
    }
}