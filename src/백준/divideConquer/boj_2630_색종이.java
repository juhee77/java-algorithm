package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class boj_2630_색종이 {
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
            int rmid = (rstart+rend)/2;
            int cmid = (cstart+cend)/2;
            if(rmid==rstart|| rmid == rend|| cmid==cstart || cmid == cend) return 0;
            return dc(arr,rstart,rmid,cstart,cmid,goal)+dc(arr,rmid,rend,cstart,cmid,goal)
                    +dc(arr,rstart,rmid,cmid,cend,goal)+dc(arr,rmid,rend,cmid,cend,goal);
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
        System.out.println(dc(arr,0,line,0,line,0)); //하얀색
        System.out.println(dc(arr,0,line,0,line,1)); //파란색
    }
}
