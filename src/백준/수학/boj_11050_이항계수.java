package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class boj_11050_이항계수 {
    public static int factorial(int n){
        if(n<=1) return 1;
        else return n*factorial(n-1);
    }

    public static int solution (int n, int k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(solution(a, b));

    }


}
