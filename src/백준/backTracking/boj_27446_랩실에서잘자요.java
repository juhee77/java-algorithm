package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_27446_랩실에서잘자요 {
    private static int lossPage;
    private static final List<Integer> page = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int all = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> save = new ArrayList<>(all);
        for (int i = 0; i < line; i++) {
            save.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= all; i++) {
            if (!save.contains(i)) page.add(i);
        }
        lossPage = page.size();
        System.out.println(findMin());
    }

    private static int findMin() {
        if(lossPage==0) return 0;

        int[] dp = new int[lossPage];
        dp[0] = 7;
        for (int i = 1; i < lossPage; i++) {
            if (page.get(i) - page.get(i - 1) > 3) {
                dp[i] = dp[i - 1] + 7;
            } else dp[i] = dp[i - 1] + (page.get(i) - page.get(i - 1)) * 2;
        }
        return dp[lossPage-1];
    }

}
