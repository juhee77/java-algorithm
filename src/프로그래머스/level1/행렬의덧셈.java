package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12950
public class 행렬의덧셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                arr1[i][j]+=arr2[i][j];
            }
        }
        return arr1;
    }

    int[][] solution2(int[][] A, int[][] B) {
        int row = Math.max(A.length, B.length);
        int col = Math.max(A[0].length, B[0].length);
        int[][] answer = new int[row][col];
        for(int i=0; i<row ; i++)
            for(int j=0; j<col; j++)
                answer[i][j] = A[i][j] + B[i][j];

        return answer;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 2 }, { 2, 3 } };
        int[][] B = { { 3, 4 }, { 5, 6 } };
        //int[][] answer = solution(A,B);

        행렬의덧셈 ans = new 행렬의덧셈();
        int[][] re= ans.solution2(A,B);
        for(int i=0;i< re.length;i++){
            for(int j=0;j<re[i].length;j++)
                System.out.print(re[i][j]+" ");
            System.out.println();
        }

    }
}
