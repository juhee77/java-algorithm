package 프로그래머스.level2;

import java.util.Arrays;
///모르겠다... ㅏㅎ야ㅏㄴ
public class Circle {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int hold = 0;
        int k=1;
        int j=0;

        for (int i=1;i<=Math.floor((n+2)/3);i++){ //그냥 반복 횟수(삼각형 cycle)
            System.out.println("--------------"+i);
            int cnt=0;
            for(;j<(n-1-i+1)*(n-i+1)/2;j=j+hold){
                if( j>=answer.length ) break;
                cnt++;
                if( answer[j]==0 ) answer[j]= k++;
                System.out.println(j+1+" "+answer[j]);
                hold++; // 계차수열

            }

            int m = j+cnt+1;
            for(;j<m;j++){
                if( j>=answer.length ) break;
                if( answer[j]==0 ) answer[j] = k++;
                System.out.println("  "+(j+1)+" "+answer[j]);
            }

            hold++;
            j--;

            for(int p =0 ; p < cnt-1; p++){
                if( j>=answer.length ) break;
                j=j-hold;
                if( answer[j]==0 )answer[j]= k++;
                System.out.println("        "+(j+1)+" "+answer[j]);
                hold--; // 계차수열

            }
            j+=hold;

        }

        return answer;
    }

    /* 이중 배열 풀이법
    int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    
    */


    public static void main(String args[]){
        System.out.println(Arrays.toString(new Circle().solution(1)));
    }
}
