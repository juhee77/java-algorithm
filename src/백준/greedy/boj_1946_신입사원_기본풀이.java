package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1946_신입사원_기본풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());// 시험 성적의 순위
                arr[i][1] = Integer.parseInt(st.nextToken());//면접 성적의 순위
            }

            //면접 순위 별로(오름차순)
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int cnt = 1; // 1차 서류 심사 결과 점수가 제일 높은 사람은 무조건 통과임
            int minRank = arr[0][1]; //어차피 앞에서 2차 점수의 제일 순위 낮음 사람하고만 비교하면 된다.
            if (n > 1) { //한명인 경우는 무조건 한명임
                for (int i = 1; i < n; i++) {
                    if (minRank > arr[i][1]) {
                        minRank = arr[i][1];
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}