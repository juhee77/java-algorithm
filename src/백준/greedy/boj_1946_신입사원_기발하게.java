package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1946_신입사원_기발하게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {//한명인 경우는 무조건 1
                sb.append(1).append("\n");
                continue;
            }

            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                //어차피 우선순위는 중복되지 않기 떄문에 가능
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());//2차 면접의 우선순위
            }

            int cnt = 1;
            int minRank = arr[1];
            for (int i = 2; i <= n; i++) {
                if (minRank > arr[i]) {
                    minRank = arr[i];
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
