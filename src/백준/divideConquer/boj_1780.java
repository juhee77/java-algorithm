package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
    private static boolean check (int arr[][], int rstart, int rend,int cstart, int cend, int goal){
        int flag = 1;
        for(int i= rstart;i<rend;i++){
            for(int j= cstart;j<cend;j++){
                if(goal!=arr[i][j]) flag =0;
                if(flag ==0 ) break;
            }
            if(flag==0) break;
        }
        if(flag==0) return false;
        else return true;
    }

    private static int dc(int arr[][], int rstart, int rend,int cstart, int cend,int goal){
//        System.out.println(rstart+" "+rend+" "+cstart+" "+cend+" ");
        if(rstart==rend || cstart==cend) return 0;
        if(check(arr,rstart,rend,cstart,cend,goal)) return 1;
        else{
            int r = (rend-rstart)/3;
            int c = (cend-cstart)/3;
            if(r==0||c==0) return 0;

            //9등분
            return dc(arr,rstart,rstart+r,cstart,cstart+c,goal)+dc(arr,rstart+r,rstart+r*2,cstart,cstart+c,goal)+dc(arr,rstart+r*2,rend,cstart,cstart+c,goal)
            +dc(arr,rstart,rstart+r,cstart+c,cstart+c*2,goal)+dc(arr,rstart+r,rstart+r*2,cstart+c,cstart+c*2,goal)+dc(arr,rstart+r*2,rend,cstart+c,cstart+c*2,goal)
            +dc(arr,rstart,rstart+r,cstart+c*2,cend,goal)+dc(arr,rstart+r,rstart+r*2,cstart+c*2,cend,goal)+dc(arr,rstart+r*2,rend,cstart+c*2,cend,goal);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int line = Integer.parseInt(br.readLine());

        int arr[][] = new int[line][line];
        //입력구간
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }


        //divide conquer
        System.out.println(dc(arr,0,line,0,line,-1)); //-1
        System.out.println(dc(arr,0,line,0,line,0)); //0
        System.out.println(dc(arr,0,line,0,line,1)); //1
    }
}
