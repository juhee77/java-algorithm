package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class E_동전교환_DFS {
    static int cnt, goal, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cnt = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        goal = Integer.parseInt(br.readLine());
        System.out.println(solution(cnt, arr, goal));

        /* -- solution --*/
        Arrays.sort(arr, Collections.reverseOrder()); //시간 초과 방지 (큰 값부터 해서 큰 경우를 버리면서 가도록)
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    /**
     * My -> knapSack알고리즘
     * 동전은 무한정 사용 가능
     */
    private static int solution(int cnt, Integer[] arr, int goal) {
        Arrays.sort(arr);
        int[][] dp = new int[cnt + 1][goal + 1];

        for (int i = 1; i <= cnt; i++) {
            int nowCoin = arr[i - 1];
            for (int j = 1; j <= goal; j++) {
                dp[i][j] = (j / nowCoin) + dp[i - 1][j % nowCoin];
                if (j >= nowCoin && i != 1) { // 큰 경우에만
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[cnt][goal];
    }


    /**
     * DFS 이용 -> 냅색 알고리즘도 가능
     * L : 사용하는 동전의 수
     */
    public static void DFS(int L, int sum, Integer[] arr) {
        if (sum > goal) return;
        if (L >= answer) return;
        if (sum == goal) {
            answer = Math.min(answer, L); //생략 가능 어차피 위에서 현재 최소값보다 큰 경우는 모두 리턴된다.
        } else {
            for (int i = 0; i < cnt; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
}
