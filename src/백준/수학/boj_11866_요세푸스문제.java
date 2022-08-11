package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11866_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");

        int num = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int now = 1;
        boolean[] arr = new boolean[num];


        for (int i = 0; i < num; i++) {
            int temp = 0;
            while (true) {
                if (!arr[now % num]) temp++;

                if(temp == cnt ) break;
                now = (now+1)%num;
            }
            arr[now%num] = true;
            now = (now==0)? num: now;
            if(i==num-1) sb.append(now);
            else sb.append(now + ", ");

        }
        System.out.println(sb+">");

    }
}
