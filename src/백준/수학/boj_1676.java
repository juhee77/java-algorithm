package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        BigInteger x = new BigInteger("1");
        x= factorial(n);
        //System.out.println(x); //확인용

        StringBuilder s = new StringBuilder(String.valueOf(x));
        s.reverse(); //출력된 팩토리얼 문자열 뒤집어서 계산

        int ans =0;
        for(;ans<s.length();ans++){
            if(s.substring(ans,ans+1).equals("0"))continue;
            else break;
        }

        System.out.println(ans);

    }

    private static BigInteger factorial(int n) {
        if(n<=1) return new BigInteger("1");
        return new BigInteger(String.valueOf(n)).multiply(factorial(n-1));
    }

}
