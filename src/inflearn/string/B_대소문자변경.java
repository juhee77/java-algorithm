package inflearn.string;

import java.util.Scanner;

public class B_대소문자변경 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "";
        for(int i=0;i<s.length();i++){
            char temp = s.substring(i,i+1).charAt(0);
            if(temp>=97)// 소문자
                ans += Character.toUpperCase(temp);
            else
                ans += Character.toLowerCase(temp);
        }
        System.out.println(ans);
    }
}
