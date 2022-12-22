package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_10653_마라톤2 {
    private static int size;
    private static int canPassed;
    private static final List<Point> allPoints = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        canPassed = Integer.parseInt(st.nextToken());

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            allPoints.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dp = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=i+1;j<Math.min(size,i+canPassed+1);j++){
                dp[i][j]=allPoints.get(i).distance(allPoints.get(j));
            }
        }

        System.out.println(dfs(size-1,canPassed));

    }

    private static int dfs(int end, int canPassed) {
        if(end==0) return 0;
        if(dp[end][canPassed]!=-1) return dp[end][canPassed];

        int min = Integer.MAX_VALUE;
        for(int i=0;i<=canPassed;i++){
            if(end-i-1<0) break;
            min = Math.min(min,dfs(end-i-1,canPassed-i)+dp[end-i-1][end]);
        }
        return dp[end][canPassed]=min;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }
    }
}
