package 리트코드;

class FindValidMatrixGivenRowandColumnSums_1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];

        int i = 0, j = 0;
        while (i < rowSum.length && j < colSum.length) {
            ans[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= ans[i][j];
            colSum[j] -= ans[i][j];

            if (rowSum[i] == 0) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);

                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}