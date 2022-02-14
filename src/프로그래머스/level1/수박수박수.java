package 프로그래머스.level1;
import java.util.*;

public class 수박수박수 {
    public static String solution(int n) {
        String answer = "";
        String[] s = {"수","박"};
        for(int i=0;i<n;i++){
            answer=answer.concat(s[i%2]);
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.print(solution(8));
    }
}
