package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_20058_마법사상어와파이어스톰 {
    private static int powSize;
    private static int[][] iceMap;
    private static boolean[][] visited;
    private static final int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        powSize = 1 << size;
        iceMap = new int[powSize + 2][powSize + 2];

        int repeat = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= powSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= powSize; j++) {
                iceMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < repeat; i++) {
            int nowSize = 1 << Integer.parseInt(st.nextToken());

            //격자부분을 돌린다 (분할된 사이즈 만큼)
            int divideSize = powSize / nowSize;
            for (int p = 0; p < divideSize; p++) {
                for (int q = 0; q < divideSize; q++) {
                    rotation(1 + nowSize * p, 1 + nowSize * q, nowSize);
                }
            }

            //인접한 칸중 얼음이 없는 칸의 개수를 센다.
            int[][] driedMap = new int[powSize + 2][powSize + 2];

            for (int p = 0; p <= powSize + 1; p++) {
                for (int q = 0; q <= powSize + 1; q++) {
                    if (iceMap[p][q] == 0) {
                        for (int[] dir : dirs) {
                            int mvX = p + dir[0];
                            int mvY = q + dir[1];

                            if (1 <= mvX && 1 <= mvY && mvX <= powSize && mvY <= powSize) {
                                driedMap[mvX][mvY]++;
                            }
                        }
                    }
                }
            }

            //얼음의 양이 줄어든다.
            for (int p = 1; p <= powSize; p++) {
                for (int q = 1; q <= powSize; q++) {
                    if (driedMap[p][q] >= 2) {
                        iceMap[p][q]--;
                        if (iceMap[p][q] < 0) {
                            iceMap[p][q] = 0;
                        }
                    }
                }
            }

        }

        long sumIce = 0;
        int maxSize = 0;
        visited = new boolean[powSize + 2][powSize + 2];
        for (int p = 1; p <= powSize; p++) {
            for (int q = 1; q <= powSize; q++) {
                sumIce += iceMap[p][q];
                if (!visited[p][q] && iceMap[p][q] > 0) {
                    maxSize = Math.max(maxSize, bfs(p, q));
                }
            }
        }

        sb.append(sumIce).append("\n").append(maxSize);
        System.out.println(sb);
    }

    private static int bfs(int p, int q) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{p, q});
        visited[p][q] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            size++;
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int mvX = poll[0] + dir[0];
                int mvY = poll[1] + dir[1];

                if (0 <= mvX && 0 <= mvY && mvX <= powSize && mvY <= powSize && !visited[mvX][mvY] && 0 < iceMap[mvX][mvY]) {
                    queue.add(new int[]{mvX, mvY});
                    visited[mvX][mvY] = true;
                }
            }
        }
        return size;
    }

    private static void rotation(int startX, int startY, int nowSize) {
        int[][] tempMap = new int[nowSize][nowSize];

        for (int i = 0; i < nowSize; i++) {
            for (int j = 0; j < nowSize; j++) {
                tempMap[j][nowSize - i - 1] = iceMap[startX + i][startY + j];
            }
        }

        for (int i = startX; i < startX + nowSize; i++) {
            System.arraycopy(tempMap[i - startX], 0, iceMap[i], startY, startY + nowSize - startY);
        }
    }
}
