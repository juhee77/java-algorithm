package 리트코드;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class SolutionLuckyNumbersinaMatrix_1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] colMax = new int[matrix[0].length];
        int[] rowMin = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            rowMin[i] = 100001;
            for (int j = 0; j < matrix[0].length; j++) {
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int max : colMax) {
            set.add(max);
        }

        List<Integer> ans = new ArrayList<>();
        for (int min : rowMin) {
            if (set.contains(min)) {
                ans.add(min);
            }
        }
        return ans;

    }

    public List<Integer> luckyNumbers2(int[][] matrix) {
        int colMax;
        int colMaxMin = Integer.MAX_VALUE;
        int rowMin;
        int rowMinMax = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            rowMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            rowMinMax = Math.max(rowMinMax, rowMin);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            colMax = 0;
            for (int j = 0; j < matrix.length; j++) {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            colMaxMin = Math.min(colMaxMin, colMax);
        }

        if (colMaxMin == rowMinMax) {
            return List.of(colMaxMin);
        }
        return List.of();
    }
}