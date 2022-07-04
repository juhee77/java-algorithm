package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 톱니바퀴 {

    //돌아가는 방향으로 회전
    public static void rot(int wheel, int direction){
        if(direction==1){
            int last = value[wheel][7];
            for(int i=7;i>0;i--) value[wheel][i]=value[wheel][i-1];
            value[wheel][0]=last;
        }else{
          int first = value[wheel][0];
          for(int i=0;i<7;i++) value[wheel][i]=value[wheel][i+1];
          value[wheel][7]=first;
        }
    }

    public static void left(int wheel, int direction){
        if(wheel<0) return;
        if(value[wheel][2]!= value[wheel+1][6]){
            left(wheel-1,-direction);
            rot(wheel,direction);
        }
        else return;
    }

    public static void right(int wheel, int direction){
        if(wheel>3) return;
        if(value[wheel][6]!=value[wheel-1][2]) {
            right(wheel+1,-direction);
            rot(wheel,direction);
        }
        else return;
    }

    static int[][] value =new int[4][8];
    public static void main(String args[]){
        Scanner sc=new Scanner((System.in));

        for(int i=0;i<4;i++){
            String line = sc.nextLine();
            for(int j=0;j<8;j++){
                value[i][j] =Character.getNumericValue(line.charAt(j));
            }
        }
        int lineNum = Integer.parseInt(sc.nextLine());

        for(int i=0;i<lineNum;i++){
            int changeWheel = sc.nextInt()-1;
            int changerotation = sc.nextInt();
            String t= sc.nextLine();
            if(changeWheel==0){
                right(changeWheel+1,-changerotation);
            }
            else if (changeWheel==1 || changeWheel==2){
                left(changeWheel-1,-changerotation);
                right(changeWheel+1,-changerotation);
            }
            else{
                left(changeWheel-1,-changerotation);
            }
            rot(changeWheel,changerotation);
        }

        int sum=value[0][0]*1+value[1][0]*2+value[2][0]*4+value[3][0]*8;
        System.out.println(Arrays.toString(value[1])+" "+sum);

    }
}
