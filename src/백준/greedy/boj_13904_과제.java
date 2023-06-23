package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13904_과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int line = Integer.parseInt(br.readLine());
        int maxDay = 0;
        int[][] arr = new int[line][2];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            maxDay = Math.max(maxDay, arr[i][0]);
        }

        Arrays.sort(arr, ((o1, o2) -> o2[0] - o1[0])); //날짜가 많은 순으로(마감기한이 넉넉한 순서대로)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]); //점수가 높은 순으로

        int idx = 0;
        int score = 0;
        for (int day = maxDay; 0 < day; day--) {
            while (idx < line && arr[idx][0] == day) {
                pq.add(arr[idx++]);
            }

            if (!pq.isEmpty()) {
//                System.out.println("선택" + Arrays.toString(pq.peek()));
                score += pq.poll()[1];
            }
        }

        System.out.println(score);
    }
}
