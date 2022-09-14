package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 양궁대회2 {
    private static int[] arr;
    private static int max = Integer.MIN_VALUE;
    private  static int[] ans;
    private static  int ansstart=0;
    private  static void backtracking(int start,int m, int d, int info[]){
        if(d==m){
            int tempmax = check(info,arr);
            if(tempmax>max){
                ans = arr.clone();
                max= tempmax;
                ansstart= start;
            }
            else if(tempmax==max && start>=ansstart){
                ans = arr.clone();
                max= tempmax;
                ansstart= start;
            }
            return;
        }
        else{
            for(int i=start;i<11;i++){
                arr[i]++;
                backtracking(i,m,d+1,info);
                arr[i]--;
            }
        }
    }

    private static int check(int a[], int r[]){
        int ryan=0,apeach=0;
        for(int i=0;i<11;i++){
            if(a[i]==r[i]&& r[i]==0) continue;
            else if(a[i]<r[i]) ryan += (10-i);
            else apeach += (10-i);
        }
        return ryan-apeach;
    }

    public int[] solution(int n, int[] info) {
        arr = new int[11];
        backtracking(0,n,0,info);
        return (max<=0)?new int[]{-1}:ans;
    }

    public static void main(String args[]){
        int []a={2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(new 양궁대회2().solution(5,a)));
        System.out.println();
        max=0;

      int []b={0,0,1,2,0,1,1,1,1,1,1};
       System.out.println(Arrays.toString(new 양궁대회2().solution(9,b)));

    }
}
