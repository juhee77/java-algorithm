package leetcode;

import java.util.Stack;

class MaxDepth {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        for(char temp : s.toCharArray()){
            if(temp=='(') stack.push(temp);
            else if (temp==')') {
                depth = Math.max(stack.size(),depth);
                stack.pop();
            }
        }
        return depth;
    }
}