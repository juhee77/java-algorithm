package 프로그래머스.level1;

public class Predicion12934 {
    public static long solution(long n) {
        //long answer = 0;
        if(Math.sqrt(n)%1==0)
            return (long) Math.pow(Math.sqrt(n)+1,2);
        else
            return -1;
    }
    public static void main(String args[]){
        System.out.println(solution(121));
        System.out.println(solution(3));
    }
}
