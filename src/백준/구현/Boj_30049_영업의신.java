package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_30049_영업의신 {
    // 영업왕 : 자신이 맡은 모든 매장의 매출액 1위
    private static int[][] human;
    //각 직원의 매장별 이익
    private static boolean[][] humanQ;
    //각 직원의 현재 영업짱인 매장 개수
    private static int[] humanQCnt;
    //매장별 최대 금액
    private static int[] shopper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        human = new int[n][m];
        humanQ = new boolean[m][n];
        humanQCnt = new int[n];
        shopper = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int shopNumber = Integer.parseInt(st.nextToken()) - 1;
                int cost = Integer.parseInt(st.nextToken()) - 1;
                solution(i, shopNumber, cost, n);
            }
        }

//        System.out.println(Arrays.toString(humanQCnt));
        // 직원 번호 , 매장번호 , 누적 매출액
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int shopNumber = Integer.parseInt(st.nextToken()) - 1;
            human[i][shopNumber] += Integer.parseInt(st.nextToken());
            int cost = human[i][shopNumber];

            solution(i, shopNumber, cost, n);
//            System.out.println(Arrays.toString(humanQCnt));
            sb.append(getTempMaxHr(k)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getTempMaxHr(int k) {
        int tempMaxHr = 0;
        for (int p : humanQCnt)
            if (p == k) tempMaxHr++;
        return tempMaxHr;
    }


    private static void solution(int i, int shopNumber, int cost, int n) {
        human[i][shopNumber] = cost;

        // 현재 가격으로 수정
        if (shopper[shopNumber] < cost) {
            shopper[shopNumber] = cost;

            // 이전에 되어있던 사람들 모두 제거
            for (int x = 0; x < n; x++) {
                if (humanQ[shopNumber][x]) {
//                    System.out.println(x + " 사람은 " + shopNumber + "매장에서 영업실패");
                    humanQ[shopNumber][x] = false;
                    humanQCnt[x]--;
                }
            }
            success(i, shopNumber);
        } else if (shopper[shopNumber] == cost) {
            //현재 사람 추가
            success(i, shopNumber);
        }
    }

    private static void success(int i, int shopNumber) {
//        System.out.println("MAX" + shopNumber + "매장은 " + i + "당당자가 영업성공");
        humanQCnt[i]++;
        humanQ[shopNumber][i] = true;
    }
}
