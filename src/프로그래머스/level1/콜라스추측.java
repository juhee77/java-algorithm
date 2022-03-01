package 프로그래머스.level1;

public class 콜라스추측 {

    public int solution(long num) {
        int cnt=0;
        while(num!=1 && cnt <500){
            cnt++;
            num=num%2==0? num/2: num*3+1;
        }
        return cnt>=500? -1: cnt;
    }

    public static void main(String args[]){
        콜라스추측 ex=new 콜라스추측();
        System.out.println(ex.solution(626331));
    }
}
