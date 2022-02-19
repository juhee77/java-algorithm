package 리트코드;

import java.util.Arrays;

public class reverseString {
    public static String reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
        return new String(s);
    }
    public static void main(String args[]){
        char[] a= {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println(reverseString(a));
    }
}
