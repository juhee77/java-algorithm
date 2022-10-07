package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1987_알파벳 {
    private static int col,row;
    private static char arr[][];
    private static boolean visit[][];
    private static ArrayList<Character> list = new ArrayList<>();
    private static int[] x = {-1,1,0,0};
    private static int[] y = {0,0,1,-1};
    private static int max =1;

    private static void dfs(int sx, int sy,int ncnt){
        for(int i=0;i<4;i++){
            int tempx = sx+x[i];
            int tempy = sy+y[i];
            if(tempx<0 || row<=tempx || tempy<0 || col<=tempy)continue;

            if(visit[tempx][tempy]) continue;
            if(list.contains(arr[tempx][tempy]))continue;

            visit[tempx][tempy]= true;
            list.add(arr[tempx][tempy]);
            max = Math.max(ncnt+1,max);
            dfs(tempx,tempy,ncnt+1);
            list.remove(list.indexOf(arr[tempx][tempy]));
            visit[tempx][tempy] = false;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new char[row][col];
        visit = new boolean[row][col];
        for(int i=0;i<row;i++){
            String temp = br.readLine();
            for(int j=0;j<col;j++){
                arr[i][j] =temp.charAt(j);
            }
        }

        list.add(arr[0][0]);
        visit[0][0] = true;
        dfs(0,0,1);
        System.out.println(max);

    }
}//1,1 A (초기값 설정의 중요성!)
