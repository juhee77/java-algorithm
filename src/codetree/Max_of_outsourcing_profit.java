package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Max_of_outsourcing_profit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

//        PriorityQueue<int[]> pq = new PriorityQueue<>(
////                new Comparator<int[]>() {
////                    @Override
////                    public int compare(int[] o1, int[] o2) {
////                        if (o1[1] == o2[1]) {
////                            if (o1[2] == o2[2]) {
////                                return o1[0] - o2[0]; //먼저 시작하는거
////                            }
////                            return o2[2] - o1[2]; // 더 돈 많이 주는거
////                        }
////                        return o1[1] - o2[1]; //더 빨리 끝나는게 먼저
////                    }
////                }
////        );
////        int n = Integer.parseInt(br.readLine());
////
////        int day = 0;
////        while (n-- > 0) {
////            st = new StringTokenizer(br.readLine());
////            int end = Integer.parseInt(st.nextToken()) + day;
////            int cost = Integer.parseInt(st.nextToken());
////            pq.add(new int[]{day, end, cost});
////            day++;
////        }
////
////        int nowDay = 0;
////        int cnt = 0;
////        while (!pq.isEmpty()) {
////            int[] poll = pq.poll();
//////            System.out.println(Arrays.toString(poll));
////            if (nowDay <= poll[0]) {
////                nowDay = poll[1];
////                cnt += poll[2];
////            }
////
////            if (poll[2] > cnt) {
////                cnt = poll[2];
////                nowDay = poll[1];
////            }
////        }
////
////        System.out.println(cnt);


        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[20][20];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[i][i + b] = c;
        }

        // i에서 j일 걸리는 일의 가장 높은 비용

        for (int p = 0; p < n; p++) {
            for (int q = 0; q < 20; q++) {
                int diff = q - p; // duringDay
                if (p >= 1 && dp[p][q] != 0) {
                    dp[p][q] = Integer.max(dp[p][q], dp[p - 1][q - diff] + dp[p][q]);
                }

                if (q >= 1) {
                    dp[p][q] = Math.max(dp[p][q], dp[p][q - 1]);
                }
                if (p!=0) {
                    dp[p][q] = Math.max(dp[p - 1][q],dp[p][q]);
                }
            }

            System.out.println(Arrays.toString(dp[p]));
        }
        System.out.println(dp[n-1][19]);


    }

}
