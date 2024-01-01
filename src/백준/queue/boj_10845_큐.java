package 백준.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int cnt = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<Integer>();
        int last = 0;
        for(int i=0;i<cnt;i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int input = Integer.parseInt(st.nextToken());
                last = input;
                queue.add(input);
            }
            else if(command.equals("pop")){
                if(queue.isEmpty())sb.append("-1").append('\n');
                else sb.append(queue.poll()).append('\n');
            }
            else if(command.equals("size")){
                sb.append(queue.size()).append('\n');
            }

            else if(command.equals("empty")){
                sb.append((queue.isEmpty())?1:0).append('\n');
            }
            else if(command.equals("front")){
                if(queue.isEmpty())sb.append("-1").append('\n');
                else sb.append(queue.element()).append('\n');
            }
            else if(command.equals("back")){
                if(queue.isEmpty())sb.append("-1").append('\n');
                else sb.append(last).append('\n');
            }
            else{
                sb.append("check rule \n");
            }
        }

        System.out.println(sb);

    }
}
