package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int whole = n * 2;
        int[] arr = new int[whole];
        st = new StringTokenizer(br.readLine());
        int remain = 0;
        for (int i = 0; i < whole; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (0 == arr[i]) remain++;
        }

        int hold = 0;
        int turn = 0;
        boolean[] robot = new boolean[whole];
        while (remain < k) {
            turn++;

            // 회전
            hold = (hold + whole - 1) % whole;

            // 로봇 내리기
            int lastPlace = (hold + n - 1) % whole;
            if (robot[lastPlace]) {
                robot[lastPlace] = false;
            }

            //로봇 이동
            for (int i = n - 1; i >= 0; i--) {
                int current = (hold + i) % whole; // 현재 로봇 위치
                int next = (current + 1) % whole; // 다음 위치

                // 현재 로봇이 있고, 다음 위치가 비어 있으며 내구도가 0보다 큰 경우
                if (robot[current] && arr[next] > 0 && !robot[next]) {
                    robot[current] = false; // 현재 로봇 내리기
                    robot[next] = true; // 다음 위치에 로봇 올리기
                    arr[next]--; // 내구도 감소
                    if (arr[next] == 0) remain++; // 내구도가 0이 되면 남은 개수 증가
                }
            }

            // 로봇 내리기
            if (robot[lastPlace]) {
                robot[lastPlace] = false;
            }

            //로봇 올리기
            if (arr[hold] > 0 && !robot[hold]) {
                robot[hold] = true; // 로봇 올리기
                arr[hold]--; // 내구도 감소
                if (arr[hold] == 0) remain++; // 내구도가 0이면 남은 개수 증가
            }

        }
        System.out.print(turn);
    }
}
