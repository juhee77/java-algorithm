package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_12789_도키도키간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        boolean isAble = true;
        int index = 1;
        for (int i = 0; i < n; i++) {
            int nowNum = Integer.parseInt(st.nextToken());
            if (nowNum == index ) {
                index++;
                while ( !stack.isEmpty() && stack.peek() == index){
                    stack.pop();
                    index++;
                }
            }else if (stack.isEmpty() || stack.peek() != index) {
                stack.add(nowNum);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != index++) {
                isAble = false;
                break;
            }
        }

        System.out.println(isAble ? "Nice" : "Sad");

    }
}
