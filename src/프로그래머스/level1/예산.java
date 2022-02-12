package 프로그래머스.level1;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/12982/solution_groups?language=java
public class 예산 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        //정렬
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            if(budget-d[i]>=0){
                budget -= d[i];
                answer++;
            }
            else break;
        }
        return answer;
    }

    public static void main(String args[]){
        int a[] = {1,3,2,4,5};
        System.out.print(solution(a,9));
    }
}
