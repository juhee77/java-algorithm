package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C_결혼식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int x = Integer.parseInt(br.readLine());
        int[][] arr = new int[x][2];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));//시작하는 순 정렬

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 넣은것중 끝나는 순으로 정렬

        int end = 1000000000;
        int cnt = 0; //현재 피로연에 있는 사람수
        int max = 0;
        for (int i = 0; i < x; i++) {
            if (arr[i][0] < end) {
                end = Math.min(end, arr[i][1]);
            }else{
                while (!pQueue.isEmpty() && pQueue.peek()[1] <= arr[i][0]) {
                    end = pQueue.poll()[1];
                    cnt--;
                }
            }

            cnt++;
            max = Math.max(max, cnt);
            pQueue.offer(arr[i]);
        }

        System.out.println(max);
    }
}
