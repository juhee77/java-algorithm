package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            //왼쪽 원 안에 있는 경우
            if(x-(h/2)<=px && px<=x && y<=py && py<=y+h && Math.pow(px-x,2)+Math.pow(py-(y+h/2),2)<=Math.pow(h/2,2))
                cnt++;

            //오른쪽 원안에 있는경우
            else if(x+w<=px && px<=x+w+(h/2) && y<=py && py<=y+h && Math.pow(px-(x+w),2)+Math.pow(py-(y+h/2),2)<=Math.pow(h/2,2))
                cnt++;
            //직사각형 안에 있는 경우
            else if(x<=px && px<=x+w && y<=py && py<=y+h) cnt++;
        }
        sb.append(cnt).append('\n');

        System.out.println(sb);
    }
}
