package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_17413_문자열뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();
        char[] reverseArray = new char[charArray.length];
        boolean openFlag = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            //별개
            if (openFlag || charArray[i] == '<' || charArray[i] == '>') {
                reverseArray[i] = charArray[i];
                if (!openFlag) {
                    //앞에것 청산 하고 감
                    reverse(reverseArray, stack, i);
                }
                openFlag = charArray[i] != '>';
            } else {
                if (charArray[i] == ' ') {
                    reverse(reverseArray, stack, i);
                    reverseArray[i] = ' ';
                }
                else{
                    stack.push(charArray[i]);
                }
            }
        }

        if (!stack.isEmpty()) {
            reverse(reverseArray, stack, charArray.length);
        }
        System.out.println(String.valueOf(reverseArray));
    }

    private static void reverse(char[] reverseArray, Stack<Character> stack, int i) {
        int size = stack.size();
        for (int j = i - size; j < i; j++) {
            reverseArray[j] = stack.pop();
        }
    }
}
