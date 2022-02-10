package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/77884
public class 약수의개수 {
    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(Math.sqrt(i)%1==0)
                answer -= i;
            else
                answer+=i;
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.print(solution(13,17));
    }
}
