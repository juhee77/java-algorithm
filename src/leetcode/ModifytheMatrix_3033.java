package leetcode;

class ModifytheMatrix_3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max;
        for(int j=0;j<col;j++){
            max = 0;
            for(int i=0;i<row;i++){
                max = Math.max(matrix[i][j],max);
            }

            for(int i=0;i<row;i++){
                if(matrix[i][j]==-1){
                    matrix[i][j] = max;
                }
            }
        }
        return matrix;
    }
}