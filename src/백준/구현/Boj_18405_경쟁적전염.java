package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_18405_경쟁적전염 {
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        Queue<int[]>[] pq = new ArrayDeque[k + 1];
        for (int i = 0; i <= k; i++) {
            pq[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    pq[arr[i][j]].add(new int[]{i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int findTime = Integer.parseInt(st.nextToken());
        int findX = Integer.parseInt(st.nextToken()) - 1;
        int findY = Integer.parseInt(st.nextToken()) - 1;


        int time = 1;
        while (!isEmpty(pq) && time <= findTime) {
            for (Queue<int[]> nowPoll : pq) {
                int size = nowPoll.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = nowPoll.poll();
                    for (int[] dir : dirs) {
                        int mvX = poll[0] + dir[0];
                        int mvY = poll[1] + dir[1];
//                        System.out.println(Arrays.toString(poll)+" "+mvX + " " + mvY);
                        if (0 <= mvX && mvX < n && 0 <= mvY && mvY < n) {
                            if (arr[mvX][mvY] == 0) {
                                //다음단계
                                arr[mvX][mvY] = arr[poll[0]][poll[1]];
                                nowPoll.offer(new int[]{mvX, mvY});
                            }
                        }
                    }
                }
            }
            time++;

//            for (int[] ints : arr) {
//                System.out.println(Arrays.toString(ints));
//            }
//            System.out.println("==============");
        }

        System.out.println(arr[findX][findY]);
    }

    private static boolean isEmpty(Queue<int[]>[] pq) {
        for (Queue<int[]> queue : pq) {
            if (!queue.isEmpty()) return false;
        }
        return true;
    }
}
