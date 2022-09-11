package 프로그래머스.level3;

import java.util.Arrays;

public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int subset[][] = new int[board.length + 2][board[0].length + 2];
        for (int ele[] : skill) {
            if (ele[0] == 1) {
                subset[ele[1] + 1][ele[2] + 1] += -ele[5];
                subset[ele[1] + 1][ele[4] + 1 + 1] += ele[5];
                subset[ele[3] + 1 + 1][ele[4] + 1 + 1] += -ele[5];
                subset[ele[3] + 1 + 1][ele[2] + 1] += ele[5];
            } else {
                subset[ele[1] + 1][ele[2] + 1] += ele[5];
                subset[ele[1] + 1][ele[4] + 1 + 1] += -ele[5];
                subset[ele[3] + 1 + 1][ele[4] + 1 + 1] += ele[5];
                subset[ele[3] + 1 + 1][ele[2] + 1] += -ele[5];
            }
        }
        for (int i = 0; i < subset.length; i++) {
            System.out.println(Arrays.toString(subset[i]));
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                subset[i + 1][j + 1] = subset[i + 1][j + 1] + subset[i][j + 1] + subset[i + 1][j] - subset[i][j];
                board[i][j] += subset[i + 1][j + 1];
                if (board[i][j] > 0) answer++;
            }
            //System.out.println(Arrays.toString(subset[i+1]));
            System.out.println(Arrays.toString(board[i]));
        }

        return answer;
    }

    public int solution2(int[][] board, int[][] skill) {
        int answer = 0;
        for (int ele[] : skill) {
            if (ele[0] == 1) {
                impl(board, ele[1], ele[3], ele[2], ele[4], -ele[5]);
            } else {
                impl(board, ele[1], ele[3], ele[2], ele[4], +ele[5]);
            }
            System.out.println();
        }
        for (int i[] : board) {
            for (int j = 0; j < i.length; j++) {
                if (i[j] > 0) answer++;
            }
        }
        return answer;
    }

    public void impl(int[][] board, int r1, int r2, int c1, int c2, int type) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] += type;
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(new 파괴되지않은건물().solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}},new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));

        System.out.println(new 파괴되지않은건물().solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
    }
}


