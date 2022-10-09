package 백준.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11057_오르막수 {
    private static final int mod = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 1; i < s; i++) {

            for (int p = 0; p < 10; p++) {
                int sum = 0;
                for (int q = p; q < 10; q++)  sum = ((sum%mod)+arr[q])%mod;
                arr[p] = sum%mod;
            }
            //System.out.println(Arrays.toString(arr));
        }

        int sum =0;
        for(int i=0;i<10;i++) sum = ((sum%mod)+arr[i])%mod;
        System.out.println(sum);
    }
}
