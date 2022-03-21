package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12973 -- 짝지어 제거하기<0321>
import java.util.Stack;

public class removeSameNumber_Stack {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        stack.add('!');
        for(int i=0;i<s.length();i++)
            if(stack.peek()==s.charAt(i)) stack.pop();
            else stack.add(s.charAt(i));

        return (stack.peek()=='!')?1:0;
    }
    public static void main(String args[]){
        System.out.println(new removeSameNumber_Stack().solution("baabaa"));
    }
}
