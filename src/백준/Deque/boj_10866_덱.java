package 백준.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int cnt = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=0;i<cnt;i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_back")){
                int input = Integer.parseInt(st.nextToken());
                deque.addLast(input);
            }
            else if(command.equals("push_front")){
                int input = Integer.parseInt(st.nextToken());
                deque.addFirst(input);
            }
            else if(command.equals("pop_front")){
                if(deque.isEmpty())sb.append("-1").append('\n');
                else sb.append(deque.pollFirst()).append('\n');
            }
            else if(command.equals("pop_back")){
                if(deque.isEmpty())sb.append("-1").append('\n');
                else sb.append(deque.pollLast()).append('\n');
            }
            else if(command.equals("size")){
                sb.append(deque.size()).append('\n');
            }

            else if(command.equals("empty")){
                sb.append((deque.isEmpty())?1:0).append('\n');
            }
            else if(command.equals("front")){
                if(deque.isEmpty())sb.append("-1").append('\n');
                else sb.append(deque.peekFirst()).append('\n');
            }
            else if(command.equals("back")){
                if(deque.isEmpty())sb.append("-1").append('\n');
                else sb.append(deque.peekLast()).append('\n');
            }
            else{
                sb.append("check rule \n");
            }
        }

        System.out.println(sb);

    }
}
