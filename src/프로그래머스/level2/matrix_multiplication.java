package 프로그래머스.level2;

import java.util.Arrays;

public class matrix_multiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[i].length;j++){
                int q=0;
                for(int p=0;p<arr2.length;p++){
                    answer[i][j] += arr1[i][q++]*arr2[p][j];
                }
                //System.out.print(answer[i][j]+" ");
            }
            //System.out.println();
        }

            return answer;
    }
    public static void main(String[] args){
        int[][] a ={{1,4},{3,2},{4,1}};
        int[][] b ={{3,3,},{3,3}};
        System.out.println(Arrays.toString(new matrix_multiplication().solution(a,b)));
    }
}
