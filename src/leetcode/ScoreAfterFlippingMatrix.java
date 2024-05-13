package leetcode;

class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        // 앞쪽에 1이 있도록 바꿈

        // 일단 맨앞은 무조건 1이 되도록 행을 뒤집음 (뒤에거 다 더해도 앞에거 안됨)
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) { // 뒤집는다
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;
                }
            }
        }

        // 각 열의 1과 0의 개수를 센다
        int hold = (int) Math.pow(2, grid[0].length - 1);
        int sum = grid.length * hold;
        for (int j = 1; j < grid[0].length; j++) {
            int zero = 0, one = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0)
                    zero++;
                else
                    one++;
            }

            hold /= 2;
            sum += Math.max(zero, one) * hold;
            //System.out.println(j+" "+sum);
        }
        return sum;
    }
}