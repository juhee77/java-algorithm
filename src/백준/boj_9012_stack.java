package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_9012_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            char c[] = s.toCharArray();
            boolean flag = true;
            stack.clear();

            for (int j = 0; j < c.length; j++) {
                if (c[j] == '(') stack.push(1);
                else {
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == true && stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);

    }
}
