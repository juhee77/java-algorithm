package 프로그래머스.level3;

public class Programmers_43105_정수삼각형 {
    public int solution(int[][] triangle) {
        int row = triangle.length;
        int col = triangle[row - 1].length;
        int[][] dp = new int[row][col];

        dp[0] = triangle[0].clone();
        // System.out.println(row+" "+col);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (0 < j) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + triangle[i][j]);
                if (j < triangle[i].length - 1) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
            }
        }

        int max = 0;
        for (int i = 0; i < col; i++) {
            max = Math.max(max, dp[row - 1][i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Programmers_43105_정수삼각형 programmers43105_정수삼각형 = new Programmers_43105_정수삼각형();
        System.out.println(programmers43105_정수삼각형.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
