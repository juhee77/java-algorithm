package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17298_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Stack<Integer> stack = new Stack<>();
        int line = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < line; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        String ans = " ";
        for (int i = 0; i < line; i++) {
            int temp = stack.pop();
            if (list.isEmpty()) ans = "-1 " + ans;
            else {
                int x = -1;
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j) > temp) {
                        x = list.get(j);
                        break;
                    }
                }
                if (x == -1) ans = "-1 " + ans;
                else ans = x + " " + ans;
            }
            list.add(temp);
        }

        System.out.println(ans);

    }
}
