package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        long arr[] = new long[101];
        arr[0]=arr[1]=arr[2]=arr[3]=1;

        for(int i=0;i<line;i++){
            int tempInput = Integer.parseInt(br.readLine());
            if(arr[tempInput]!=0)sb.append(arr[tempInput]).append('\n');
            else{
                for(int j=4;j<=tempInput;j++)arr[j]=arr[j-2]+arr[j-3];
                sb.append(arr[tempInput]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
