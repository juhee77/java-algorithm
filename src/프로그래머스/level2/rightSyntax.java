package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12909 -- 올바른 괄호 <0328>
import java.util.Stack;

public class rightSyntax {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        stack.add(' ');

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' && stack.peek()=='(') stack.pop();
            else if( s.charAt(i)==')' && stack.peek()==')') return false;
            else stack.add(s.charAt(i));
        }

        return stack.size()==1 ? true: false;
    }
    public static void main(String args[]){
        System.out.println(new rightSyntax().solution("()()"));
    }
}
