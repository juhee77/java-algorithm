package 프로그래머스.level2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42747 -- H-index<0404>
public class Hindex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations[citations.length-1];i++){
            int middle = i;
            int low=0,high=0;
            for(int j=0;j<citations.length;j++){
                if(middle<=citations[j])high++;
                if(citations[j]<=middle)low++;
            }
            if(low <=middle && middle <= high) answer = middle;

        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(new Hindex().solution(new int[] {3,0,6,1,5}));
        System.out.println(new Hindex().solution(new int[] {10,10,10,10,10}));
    }
}
