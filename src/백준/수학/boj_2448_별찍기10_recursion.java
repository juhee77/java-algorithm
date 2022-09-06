package 백준.수학;

import java.util.Scanner;

public class boj_2448_별찍기10_recursion {
    private static StringBuilder sb = new StringBuilder();
    private static String[][] arr;
    private static void star(int startX, int endX,int startY,int endY){
        if(startX==endX|| startY==endY )return;

        if(startX+1==endX && startY+1 == endY){
            arr[startX][startY] = "*";
            return;
        }

        //123456789
        int xmid = (endX-startX)/3;
        int ymid = (endY-startY)/3;
        star(startX,startX+xmid,startY,startY+ymid);
        star(startX+xmid,startX+xmid*2,startY,startY+ymid);
        star(startX+xmid*2,endX,startY,startY+ymid);

        star(startX,startX+xmid,startY+ymid,startY+ymid*2);
        for(int i=startY+ymid;i<startY+ymid*2;i++){
            for(int j=startX+xmid;j<startX+xmid*2;j++){
                arr[i][j]=" ";
            }
        }
        star(startX+xmid*2,endX,startY+ymid,startY+ymid*2);

        star(startX,startX+xmid,startY+ymid*2,endY);
        star(startX+xmid,startX+xmid*2,startY+ymid*2,endY);
        star(startX+xmid*2,endX,startY+ymid*2,endY);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        arr = new String[x][x];
        star(0,x,0,x);
        for(int i=0;i<x;i++){
            for(int j =0;j<x;j++)
                sb.append(arr[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
