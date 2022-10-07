package 백준.수학;

import java.util.Scanner;

public class 완전제곱수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;

        int i= (m==1)?1:(int) Math.sqrt(m)+1;

        for ( ; i <= Math.sqrt(n); i++) {
            int temp = i * i;
            sum += temp;
            if (min == Integer.MAX_VALUE) min = temp;
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(sum + " \n" + min);
    }
}
