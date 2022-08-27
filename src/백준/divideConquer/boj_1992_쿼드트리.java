package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992_쿼드트리 {
    private static int check (int arr[][], int rstart, int rend,int cstart, int cend){
        int flag = 1;
        int goal = arr[rstart][cstart];
        for(int i= rstart;i<rend;i++){
            for(int j= cstart;j<cend;j++){
                if(goal!=arr[i][j]) flag =0;
                if(flag ==0 ) break;
            }
            if(flag==0) break;
        }
        if(flag==0) return -1;
        else return goal;
    }

    private static String dc(int arr[][], int rstart, int rend,int cstart, int cend){
        //System.out.println(rstart+" "+rend+" "+cstart+" "+cend+" ");
        if(rstart==rend || cstart==cend) return "";

        int chk = check(arr,rstart,rend,cstart,cend);
        if(chk!=-1) return String.valueOf(chk);
        else{
            int rmid = (rstart+rend)/2;
            int cmid = (cstart+cend)/2;
            if(rmid==rstart|| rmid == rend|| cmid==cstart || cmid == cend) return "";
            return "("+dc(arr,rstart,rmid,cstart,cmid)+dc(arr,rstart,rmid,cmid,cend) //왼쪽위 오른쪽 위
                    +dc(arr,rmid,rend,cstart,cmid)+dc(arr,rmid,rend,cmid,cend)+")"; //왼쪽아래, 오른쪽 아래
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int line = Integer.parseInt(br.readLine());

        int arr[][] = new int[line][line];
        //입력구간
        for (int i = 0; i < line; i++) {
            String s= br.readLine();
            for (int j = 0; j < line; j++)
                arr[i][j] = Integer.parseInt(s.substring(j,j+1));
        }
        //divide conquer
        System.out.println(dc(arr,0,line,0,line));
    }
}
