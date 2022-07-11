package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m2per = Integer.parseInt(br.readLine());

        int maxX=0,minX=501,maxY=0,minY=501;
        int firstF=0,secondF=0;

        for(int i=0;i<6;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(dir==1 || dir==2 ){
                maxX=Math.max(maxX,distance);
                if(firstF==0)firstF=1;
                else if( firstF==1){
                    minX=distance;
                    firstF++;
                }
            }
            else if(dir ==3||dir==4) {
                maxY = Math.max(maxY, distance);
                if(secondF==0)secondF=1;
                else if( secondF==1){
                    minY=distance;
                    secondF++;
                }
            }


        }
        int all = maxX*maxY-minX*minY;
        System.out.println(all*m2per);
    }
}
