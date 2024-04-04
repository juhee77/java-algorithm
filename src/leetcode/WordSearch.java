package leetcode;

import java.awt.*;
import java.util.ArrayList;

class WordSearch {
    private static boolean[][] visited;
    private static char[][] tempBoard;
    private static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private String tempWord;

    public boolean exist(char[][] board, String word) {
        if (word.equals(""))
            return true;
        tempWord = word;
        tempBoard = board;
        ArrayList<Point> start = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == tempWord.charAt(0))
                    start.add(new Point(i, j));
            }
        }

        // System.out.println(start);
        for (Point point : start) {
            visited = new boolean[board.length][board[0].length];
            visited[point.x][point.y] = true;
            if (findDFS(point.x, point.y, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean findDFS(int x, int y, int depth) {
        // System.out.println(depth);
        if (depth == tempWord.length()-1) {
            return true;
        }

        for (int[] dir : dirs) {
            int mvX = dir[0] + x;
            int mvY = dir[1] + y;
            if (mvX < 0 || mvY < 0 || visited.length <= mvX || visited[0].length <= mvY || visited[mvX][mvY])
                continue;

            if (tempWord.charAt(depth+1) == tempBoard[mvX][mvY]) {
                visited[mvX][mvY] = true;
                if(findDFS(mvX, mvY, depth + 1)) return true;
                visited[mvX][mvY] = false;
            }
        }
        return false;
    }
}