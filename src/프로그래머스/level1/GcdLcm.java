package 프로그래머스.level1;

import java.util.Arrays;

public class GcdLcm {

    public int[] solution(int n, int m) {
        int max=(n>m)?n:m;
        int min=(n>m)?m:n;
        int i=1;

        while(true)
            if(min*(i++) % max==0)
                break;

        for(;max>0;max--)
            if(n%max==0 && m%max==0)
                break;

        return new int[] {max,min*(i-1)};
    }
    //유클리드 호제법(최대공약수)
    public  int gcd (int n,int m){
        if(m==0) return n;
        else return gcd(m,n%m);
    }
    //유클리드 호제번 (최대공배수)
    public int lcm(int n,int m){
        return n*m/gcd(n,m);
    }

    public static void main(String args[]){
        GcdLcm ex = new GcdLcm();
        System.out.println(Arrays.toString(ex.solution(3,12)));
        System.out.println(Arrays.toString(ex.solution(2,5)));
    }
}
