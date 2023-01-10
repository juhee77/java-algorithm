package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class E_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr = br.readLine();
        System.out.println(solution(arr.toCharArray()));
        System.out.println(solution2(arr));

    }

    private static int solution(char[] arr) {
        Stack<Integer> stack = new Stack<>();
        int cnt =0;

        for (int i=0;i<arr.length;i++) {
            if(arr[i]=='(') {
                stack.add(i);
            }
            else{
                if(stack.pop()==i-1) cnt += (stack.size());
                else cnt += 1;
            }
        }
        return cnt;
    }


    public static int solution2(String str){
        int cnt=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push('(');
            else{
                stack.pop();
                if(str.charAt(i-1)=='(') cnt+=stack.size();
                else cnt++;
            }
        }
        return cnt;
    }
}
