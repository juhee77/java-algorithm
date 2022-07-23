package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        for(int i=0;i<line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            int goalx = Integer.parseInt(st.nextToken());
            int goaly = Integer.parseInt(st.nextToken());

            int t=Integer.parseInt(br.readLine());
            int cnt =0 ;

            for(int test=0;test<t;test++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r =Integer.parseInt(st.nextToken());

                //시작점과 끝점이 모두 행성에 포함된 경우
                if(Math.pow(startx-x,2)+Math.pow(starty-y,2)<Math.pow(r,2)&&Math.pow(goalx-x,2)+Math.pow(goaly-y,2)<Math.pow(r,2))
                    continue;

                //둘중에 하나만 포함되는 경우(시작 끝점인 경우 진입 or 이탈이 필요 )
                else if(Math.pow(startx-x,2)+Math.pow(starty-y,2)<Math.pow(r,2)||Math.pow(goalx-x,2)+Math.pow(goaly-y,2)<Math.pow(r,2))
                    cnt++;

            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
