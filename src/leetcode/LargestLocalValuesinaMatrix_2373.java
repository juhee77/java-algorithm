package leetcode;

class LargestLocalValuesinaMatrix_2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];

        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {

                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; j++) {
                        ans[i - 1][j - 1] = Math.max(ans[i - 1][j - 1], grid[x][y]);
                    }
                }
            }
        }
        return ans;
    }
}