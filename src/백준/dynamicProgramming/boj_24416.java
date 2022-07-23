package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24416 {
    /*
    static int arr[] = new int[41];
    static int cnt=0;
    static void fibonacciDp(int k){
        if(k<=2) cnt++;
        else if(arr[k-1]!=0 && arr[k-2]!=0) {
            arr[k]=arr[k-2]+arr[k-1];
        }
        else {
            cnt++;
            fibonacciDp(k-1) ;
            fibonacciDp(k-2);
            arr[k]=arr[k-2]+arr[k-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr[1] = arr[2] = 1;
        fibonacciDp(n);
        System.out.println(arr[n] + " " + cnt);
    }
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int arr[] = new int[41];
        int n = Integer.parseInt(br.readLine());

        arr[1]=arr[2]=1;
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println(arr[n]+" "+(n-2));

    }
}
