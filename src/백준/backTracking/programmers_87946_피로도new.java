package 백준.backTracking;

import java.util.Arrays;

public class programmers_87946_피로도new {
    public static int ans = 0;
    public static int[] visit;

    public void dfs(int[][] dungeons,int d, int k) {

        System.out.println(Arrays.toString(visit));
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && visit[i] == 0) {
                visit[i] = 1;
                dfs(dungeons, d + 1, k - dungeons[i][1]);
                visit[i] = 0;
            }
        }

        ans = Math.max(d,ans);


    }

    public int solution(int k, int[][] dungeons) {

        visit = new int[dungeons.length];
        dfs(dungeons, 0, k);
        if (ans != 0) return ans;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new programmers_87946_피로도new().solution(30, new int[][]{{60, 20}, {80, 80}, {10, 10}}));
        System.out.println(new programmers_87946_피로도new().solution(80, new int[][]{{60, 20}, {80, 20}, {10, 10}}));
    }
}
