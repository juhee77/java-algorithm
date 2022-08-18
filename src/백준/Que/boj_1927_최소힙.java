package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1927_최소힙 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for(int i = 0; i < line;i++){
            int input =Integer.parseInt(br.readLine());
            if(input ==0 ) {
                if(q.isEmpty()) sb.append("0").append('\n');
                else sb.append(q.poll()).append('\n');
            }
            else
                q.add(input);
        }
        System.out.println(sb);
    }
}
