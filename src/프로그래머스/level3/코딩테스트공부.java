package 프로그래머스.level3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class 코딩테스트공부 {
    public int solution(int alp, int cop, int[][] problems) {
        int arr[][] = new int[151][151];
        int alpmax = 0, copmax =0;
        for(int i=0;i<= problems.length;i++){
            alpmax = Math.max(alpmax,problems[i][0]);
            copmax = Math.max(copmax,problems[i][1]);
        }

        arr[alp][cop] = 0;
        int answer = Integer.MAX_VALUE;
        for (int alp2 = alp; alp2 < alpmax+1; alp2++) { //alp
            for (int cop2 = cop; cop2 < copmax+1; cop2++) {
                boolean flag = false;

                for (int j = 0; j < problems.length; j++) {
                    //해당 문제를 풀기에 필요한 점수가 부족한 경우
                    if (alp2 < problems[j][0] || cop2 < problems[j][1]) {
                        flag = true;
                        continue;
                    }
                    int tempalp2 = alp2 + problems[j][2];
                    int tempcop2 = cop2 + problems[j][3];
                    int temptime2 = arr[alp2][cop2] + problems[j][4];
                    if (tempalp2 > 150 || tempcop2 > 150) continue;
                    //if(alp2<=20&&cop2<=20)System.out.println(alp2+" "+cop2+" "+tempalp2+" "+tempcop2+" "+temptime2);
                    if (arr[tempalp2][tempcop2] == 0) arr[tempalp2][tempcop2] = temptime2;
                    else arr[tempalp2][tempcop2] = Math.min(arr[tempalp2][tempcop2], temptime2);
                }

                if (!flag) answer = Math.min(answer,arr[alp2][cop2]);
//                System.out.println(alp2+" "+answer);

                int[] x = {0, 1};
                int[] y = {1, 0};
                for (int j = 0; j < 2; j++) {
                    int tempalp2 = alp2 + x[j];
                    int tempcop2 = cop2 + y[j];
                    int temptime2 = arr[alp2][cop2] + 1;
                    //목표값보다 더 크면
                    if (tempalp2 > 150 || tempcop2 > 150) continue;

                    if (arr[tempalp2][tempcop2] == 0) arr[tempalp2][tempcop2] = temptime2;
                    else arr[tempalp2][tempcop2] = Math.min(arr[tempalp2][tempcop2], temptime2);
                }

            }
            //System.out.println(alp2+" "+Arrays.toString(arr[alp2]));

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 코딩테스트공부().solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 2, 1, 2}}));
        System.out.println(new 코딩테스트공부().solution(0, 0, new int[][]{{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}}));
    }
}
