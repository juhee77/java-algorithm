package 프로그래머스.level2;

import java.util.Arrays;

public class hanoi {
    static int k=0;
    private static final StringBuilder s = new StringBuilder();
    public static void hanoi(int n, int start,int end, int mid, int answer[][]){
        if(n==0)return;
        hanoi(n - 1, start, mid, end,answer);
        answer[k][0]=start;
        answer[k][1]=end;
        k++;
        hanoi(n - 1, mid, end, start,answer);

    }

    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2,n)-1][2];
        hanoi(n,1,3,2,answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] ans = new hanoi().solution(2);
        for(int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }

}
