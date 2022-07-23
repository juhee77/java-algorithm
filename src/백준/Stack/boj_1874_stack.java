package 백준.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int line = Integer.parseInt(br.readLine());
        int now = 1;
        int flag = 1;

        int input = Integer.parseInt(br.readLine());
        for(int j=0;j<input;j++){
            stack.push(now++);
            sb.append('+').append('\n');
        }
        sb.append('-').append('\n');
        stack.pop();
        //System.out.println(stack);

        for(int i=1;i<line;i++){
            input = Integer.parseInt(br.readLine());

            System.out.println(stack);
            int tempPeek = (stack.isEmpty())?0:stack.peek();
            if(tempPeek==input) {
                if(stack.isEmpty()){
                    flag=0;
                    break;
                }
                sb.append('-').append('\n');
                stack.pop();
            }
            else if (tempPeek <input){
                for(;now<=input;){
                    stack.push(now++);
                    sb.append('+').append('\n');
                }
                sb.append('-').append('\n');
                stack.pop();
            }
            else if(tempPeek>input){
                flag=0;
            }
        }

        if (flag == 1 && stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");

    }
}
