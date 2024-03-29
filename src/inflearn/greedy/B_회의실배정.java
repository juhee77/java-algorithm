package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_회의실배정 {
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
        //끝나는 시간 기준 정렬

        Arrays.sort(arr, (o1, o2) -> {//수업이 빨리 끝나는 순서로 저장, 만약 같은시간에 끝나면 수업이 먼저 시작하는 순서로
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int end = 0;
        int cnt = 0;
        for (int[] now : arr) {
            if (end <= now[0]) { //수업이 끝나고 다음수업을 들을 수 있는지
                cnt++;
                end = now[1];
            }
        }
        System.out.println(cnt);
    }
}
