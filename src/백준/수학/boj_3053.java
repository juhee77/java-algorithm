package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n=Integer.parseInt(br.readLine());
        System.out.printf("%.6f\n",n*n*3.14159265358979323846264338327950288);
        System.out.printf("%.6f\n",n*n*2);

    }
}
