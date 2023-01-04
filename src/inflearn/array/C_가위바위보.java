package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_가위바위보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0;i<line;i++){
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st2.nextToken());
            char win ;
            if(first == second)  win = 'D';// 비김
            else if( second-first == 1) win = 'B';
            else if(first-second==1)win ='A';
            else if(first == 3) win='B';
            else win='A';

            sb.append(win+"\n");
        }
        System.out.println(sb);
    }
}
