package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_11286_절댓값힙 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(); //양수
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(Collections.reverseOrder());//음수

        for (int i = 0; i < line; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (q.isEmpty() && q2.isEmpty()) sb.append("0").append('\n');
                else {
                    //두개중 하나가 empty인경우
                    if (q.isEmpty())
                        sb.append(q2.poll()).append('\n');
                    else if (q2.isEmpty())
                        sb.append(q.poll()).append('\n');
                    else {
                        int first = q.peek(); //가장큰
                        int last = q2.peek(); //가장작은

                        if (Math.abs(first) >= Math.abs(last)) sb.append(q2.poll()).append('\n');
                        else sb.append(q.poll()).append('\n');
                    }
                }
            }
            else {
                if (input > 0) q.add(input);
                else q2.add(input);
            }
        }
        System.out.println(sb);
    }
}
