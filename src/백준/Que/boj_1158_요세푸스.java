package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1158_요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= a; i++) {
            queue.add(i);
        }
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int j = 0; j < b - 1; j++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if(queue.size()>=1) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);


    }
}
