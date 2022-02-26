package 프로그래머스.level1;
import java.util.*;

public class 자릴수더하기 {

        public int solution(int n) {
            int answer = 0;

            while(0<n){
                answer+=n%10;
                n/=10;
            }
            return answer;
        }
        public static void main(String args[]){
            자릴수더하기 a = new 자릴수더하기();
            System.out.println(a.solution(123));
        }
}
