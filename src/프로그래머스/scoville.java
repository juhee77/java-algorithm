package 프로그래머스;

import java.util.*;

public class scoville {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int index = 0;
        while(true){
            Arrays.sort(scoville);
            if(scoville[index]>=K){
                return answer;
            }
            else{
                if(index+1== scoville.length){
                    return -1;
                }
                scoville[index+1]=scoville[index]+(scoville[index+1]*2);
                scoville[index]=0;
                index++;
                answer++;
            }
        }
    }
    public static void main(String args[]){
        int[] numbers= {1,2,3,9,10,12};
        System.out.println(solution(numbers,7));
        //int[] numbers1= {5,8,4,0,6,7,9};
        //System.out.println(solution(numbers1));
    }
}
