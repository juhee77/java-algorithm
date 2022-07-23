package 백준.수학;
import java.util.Scanner;

public class 분수찾기 {
    public static String solution(int n){
        int i=1;
        for(;i<n;i++){
            if(n>i)
                n = n-i;
            else
                break;
        }

        if(i%2==0)
            return n+"/"+(i-n+1);
        else
            return (i-n+1)+"/"+n;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner((System.in));
        System.out.println(solution(sc.nextInt()));
    }
}
