package 프로그래머스.level2;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/12941 -- 최솟값 만들기 <0324>

public class makeSmallNum {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[B.length-1-i];
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(new makeSmallNum().solution(new int[]{1,4,2},new int[]{5,4,4}));
    }
}
