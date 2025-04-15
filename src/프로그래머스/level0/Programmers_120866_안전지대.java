package 프로그래머스.level0;

class Programmers_120866_안전지대 {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] dead = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int mvX = dir[0] + i;
                        int mvY = dir[1] + j;

                        if (0 <= mvX && mvX < n && 0 <= mvY && mvY < n) {
                            if (!dead[mvX][mvY]) {
                                dead[mvX][mvY] = true;
                                if (board[mvX][mvY] == 0) answer--;
                            }
                        }

                    }
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_120866_안전지대 solved = new Programmers_120866_안전지대();
        System.out.println(solved.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}));
    }
}