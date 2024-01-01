package 백준.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> s = new Stack<>();
        String ans = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 65) ans += input.charAt(i);
            else {
                char now = input.charAt(i);

                if (now == '(') s.push(now);

                else if (now == ')') {
                    while (true) {
                        char tmppop = s.pop();
                        if (tmppop == '(') break;
                        else ans += tmppop;
                    }
                }

                else {
                    if (now == '*' || now == '/') {
                        while (!s.isEmpty()) {
                            if(s.peek()=='*'||s.peek()=='/')ans += s.pop();
                            else break;
                        }
                        s.push(now);
                    } else { //+-
                        while (!s.isEmpty()) {
                            if(s.peek()=='(')break;
                            ans += s.pop();
                        }
                        s.push(now);
                    }
                }
            }
        }

        while(!s.isEmpty()){
            ans += s.pop();
        }
        System.out.println(ans);

    }
}
