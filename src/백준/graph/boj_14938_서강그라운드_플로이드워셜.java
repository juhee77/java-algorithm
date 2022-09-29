package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14938_서강그라운드_플로이드워셜 {
    private static final int INF = (int) 1e9;
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int available=Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        int stock[] = new int[city];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<city;i++) stock[i] = Integer.parseInt(st.nextToken());

        int arr[][] = new int [city][city];
        for(int i=0;i<city;i++){
            Arrays.fill(arr[i],INF);
            arr[i][i]=0;
        }

        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            arr[a][b]=arr[b][a]=d;
        }


        //플로이드 워셜
        for(int i=0;i<city;i++){
            for(int p=0;p<city;p++){
                for(int q=0;q<city;q++){
                    arr[p][q]= Math.min(arr[p][q],arr[p][i]+arr[i][q]);
                }
            }
        }

        int max =0;
        for(int i=0;i<city;i++){
            int temp=0;
            for(int j=0;j<city;j++){
                if(arr[i][j]<=available)temp+= stock[j];
            }
            max= Math.max(temp,max);
        }

        System.out.println(max);

    }
}
