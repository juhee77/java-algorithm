package inflearn;

import java.util.Scanner;

public class 문자찾기_1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.next().toLowerCase();
        String find = in.next().toLowerCase();

        int ans =0;
        int current =0;

        while(true){
            if(s.indexOf(find,current)==-1) break;
            ans++;
            current = s.indexOf(find,current)+1;
        }
        System.out.println(ans);
        return ;
    }
}
