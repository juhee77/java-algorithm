package 프로그래머스.level1;

public class hasadnumber {
    public boolean solution(int x) {
        int copy=x;
        int sum=0;
        while(copy>0){
            sum+=copy%10;
            copy/=10;
        }
        // int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum(); 표현 가능
        return x%sum==0 ? true: false;
    }
    public static void main(String args[]){
        hasadnumber ex = new hasadnumber();
        System.out.println(ex.solution(18));
    }
}
