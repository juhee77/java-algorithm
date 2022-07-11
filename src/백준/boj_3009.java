package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int savex=-1,savey=-1;
        int savex2=-1,savey2=-1;
        for(int i=0;i<3;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(savex==x) savex=-1;
            else if(savex2==x)savex2=-1;
            else {
                if(savex==-1) savex=x;
                else savex2=x;
            }

            if(savey==y) savey=-1;
            else if(savey2==y)savey2=-1;
            else {
                if(savey==-1) savey=y;
                else savey2=y;
            }
        }

        int x=(savex==-1)?savex2:savex;
        int y=(savey==-1)?savey2:savey;
        System.out.println(x+" "+y);
    }
}
