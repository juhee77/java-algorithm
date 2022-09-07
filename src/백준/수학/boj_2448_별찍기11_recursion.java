package 백준.수학;

import java.util.Scanner;

public class boj_2448_별찍기11_recursion {
    private static StringBuilder sb = new StringBuilder();
    private static String[][] arr;
    private static void star(int startX, int endX,int startY,int endY){
        if(startX==endX|| startY==endY )return;

        if(endY-startY==3){ //사이즈가 3이라면
            arr[startY][startX+2] = "*";

            arr[startY+1][startX+1] = "*";
            arr[startY+1][startX+3] = "*";

            for(int i=startX;i<startX+5;i++){
                arr[endY-1][i]="*";
            }
            return;
        }

        //크게 3등분
        int xmid = (endX-startX)/4;
        int ymid = (endY-startY)/2;

        star(startX+xmid*1,startX+xmid*3,startY,startY+ymid);

        star(startX,startX+xmid*2,startY+ymid,endY);
        star(startX+xmid*2,endX,startY+ymid,endY);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        arr = new String[x][x*2];
        for(int i=0;i<x;i++){
            for(int j=0;j<x*2;j++){
                arr[i][j]=" ";
            }
        }
        star(0,x*2,0,x);
        for(int i=0;i<x;i++){
            for(int j =0;j<x*2;j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
