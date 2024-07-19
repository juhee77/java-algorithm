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
}