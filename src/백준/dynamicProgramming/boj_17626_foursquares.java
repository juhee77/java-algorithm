package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17626_foursquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal =Integer.parseInt(br.readLine());
        int arr[]= new int[goal+1];
        for(int i=1;i<=goal;i++){
            if(Math.pow(i,0.5)%1==0)arr[i]=1;
            else{
                arr[i]=Integer.MAX_VALUE;
                for(int j=1;j*j<=i;j++)
                    arr[i]= Math.min(arr[i],arr[i-j*j]+1);
                //arr[i] = Math.mins(arr[i],arr[i-j*j]+arr[j*j]) // arr[j*j] 는 무조건 1임
            }
//            System.out.println(i+" "+arr[i]);
        }

        System.out.println(arr[goal]);

    }
}
