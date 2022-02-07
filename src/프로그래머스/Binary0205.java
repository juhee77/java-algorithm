package 프로그래머스;

import java.util.*;

class Binary0205  {
    public static int solution(int n) {
        int answer = 0;
        String dec = "";
        int i=1;

        while(3<=n){
            int  temp = n % 3;
            n = n/3;
            answer += temp*i;
            i*=3;
        }
        answer += n*i;
        return answer;
    }

    public static void main(String args[]){
        int numbers= 45;
        System.out.println(solution(numbers));
        int numbers1= 125;
        System.out.println(solution(numbers1));
    }
}