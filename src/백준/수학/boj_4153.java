package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[]=new int[3];
            int zeroCnt=0;
            for(int i=0;i<3;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                if(arr[i]==0)zeroCnt++;
            }
            if(zeroCnt==3)break;

            Arrays.sort(arr);
            if(Math.pow(arr[0],2)+Math.pow(arr[1],2)==Math.pow(arr[2],2))
                sb.append("right"+'\n');
            else
                sb.append("wrong"+'\n');
        }

        System.out.println(sb);
    }
}
