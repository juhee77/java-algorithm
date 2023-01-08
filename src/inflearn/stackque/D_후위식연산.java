package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D_후위식연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        System.out.println(solution(arr));
        System.out.println(solution2(new String(arr)));
    }

    private static int solution(char[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (char c : arr) {
            if('0'<=c && c<='9') stack.push(c-'0');
            else{
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                if(c == '+') result = a + b;
                else if(c=='-') result = a - b;
                else if(c=='*') result = a*b;
                else if(c=='/') result = a/b;
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static int solution2(String str){
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-48);
            }
            else{
                int rt=stack.pop();
                int lt=stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if(x=='-') stack.push(lt-rt);
                else if(x=='*') stack.push(lt*rt);
                else if(x=='/') stack.push(lt/rt);
            }
        }
        return stack.get(0);
    }
}
