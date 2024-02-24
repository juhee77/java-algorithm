package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char temp : s.toCharArray()){
            if(temp=='('||temp=='['||temp=='{'){
                stack.push(temp);
            }else if(stack.isEmpty()){
                return false;
            }else if(temp==')'){
                if(stack.peek()=='(') stack.pop();
                else return false;
            }else if(temp==']'){
                if(stack.peek()=='[') stack.pop();
                else return false;
            }else if(temp=='}'){
                if(stack.peek()=='{') stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("[]"));
        System.out.println(validParentheses.isValid("[("));
        System.out.println(validParentheses.isValid(")]"));

    }
}
