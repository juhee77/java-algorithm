package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10828_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int cnt = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<cnt;i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int input = Integer.parseInt(st.nextToken());
                stack.push(input);
            }
            else if(command.equals("pop")){
                if(stack.empty())sb.append("-1").append('\n');
                else sb.append(stack.pop()).append('\n');
            }
            else if(command.equals("size")){
                sb.append(stack.size()).append('\n');
            }
            else if(command.equals("top")){
                if(stack.empty())sb.append("-1").append('\n');
                else sb.append(stack.peek()).append('\n');
            }

            else if(command.equals("empty")){
                sb.append((stack.empty())?1:0).append('\n');
            }
            else{
                System.out.println("check rule");
            }
        }

        System.out.println(sb);

    }
}
