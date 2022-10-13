package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17404_RGB2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        int arr[][] = new int[house][9];

        for(int i=0;i<house;i++){
            Arrays.fill(arr[i],(int)1e9);
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(i==0) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][4] = Integer.parseInt(st.nextToken());
                arr[i][8] = Integer.parseInt(st.nextToken());
            }
            else {
                int red = Integer.parseInt(st.nextToken());
                int green = Integer.parseInt(st.nextToken());
                int blue = Integer.parseInt(st.nextToken());
                for(int j=0;j<9;j+=3){
                    arr[i][j+0] = Math.min(arr[i-1][j+1]+red,arr[i-1][j+2]+red);
                    arr[i][j+1] = Math.min(arr[i-1][j+0]+green,arr[i-1][j+2]+green);
                    arr[i][j+2] = Math.min(arr[i-1][j+0]+blue,arr[i-1][j+1]+blue);
                }
            }

        }
       int min = Integer.MAX_VALUE;
        int minarr[] = new int[]{1,2,3,5,6,7} ;
        for(int i=0;i<minarr.length;i++){
            min= Math.min(min,arr[house-1][minarr[i]]);
        }
        System.out.println(min);

    }
}
