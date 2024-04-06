package leetcode;

import java.util.Stack;

class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        boolean[] removes = new boolean[s.length()];

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    removes[i] = true;
                }
            }
        }

        while (!stack.isEmpty()) {
            removes[stack.pop()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (!removes[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}