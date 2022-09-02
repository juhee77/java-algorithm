package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_2407_조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(multiply(n-m+1,n).divide(multiply(1,m)) );

    }
    private static BigInteger multiply(int x, int y){
        BigInteger result = new BigInteger("1");
        for(int i=x;i<=y;i++){
            result=result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}
