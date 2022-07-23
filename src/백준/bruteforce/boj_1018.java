package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {
    public static int check(char arr[][], int x, int y){
        int cnt1=0;
        int cnt2=0;
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++) {
                char temp = (i+j)%2==0? 'W':'B';
                if(arr[i][j]==temp) continue;
                else cnt1++;
            }
            for(int j=y;j<y+8;j++) {
                char temp = (i+j)%2==1? 'W':'B';
                if(arr[i][j]==temp) continue;
                else cnt2++;
            }
        }
        return (cnt1>cnt2)?cnt2:cnt1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int row= Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char arr[][] = new char[row][col];
        //int cnt[][] = new int [row-8][col-8];
        int min=1000;

        for(int i=0;i<row;i++){
            String temp = br.readLine();
            arr[i]=temp.toCharArray();
        }

        for(int i=0;i<=row-8;i++){
            for(int j=0;j<=col-8;j++){
                int temp = check(arr,i,j);
                min= (temp<min)?temp:min;
                if(min ==0) break;
            }
            if(min ==0) break;
        }
        System.out.println(min);
    }
}
