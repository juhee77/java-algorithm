package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/92335 -- k진수에서 소수 개수 구하기 <0327>
import java.util.Arrays;

public class kRadixPrime {
    public int solution(int n, int k) {
        int answer = 0;
        String ans = Integer.toString(n,k);
        String list[] = ans.split("0+");
        System.out.println(Arrays.toString(list));

        for(String s : list)
            if (checkPrime(Long.parseLong(s))) answer++;
            //if (!s.replace(" ","").equals("") && checkPrime(Integer.parseInt(s))) answer++;
        return answer;
    }
    public boolean checkPrime( Long n){
        if(n==1) return false;
        for(int i=2;i<Math.sqrt(n)+1;i++){ //제곱근 만큼 돌아도 계산 가능
            if(i!=n && n%i==0) return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(new kRadixPrime().solution(437674,3));
        System.out.println(new kRadixPrime().solution(524287,2));
    }
}
