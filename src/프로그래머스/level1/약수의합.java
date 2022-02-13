package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12928
public class 약수의합 {
    public static int solution(int n) {
        int answer = 0;
        for(int i=1;i<Math.sqrt(n);i++){
            if(n%i==0){
                answer = answer + i + n/i;
            }
        }
        if(Math.sqrt(n)%1==0){
            answer+=Math.sqrt(n);
        }

        return answer;
    }
    public static void main(String args[]){
        System.out.print(solution(12));
    }
}
