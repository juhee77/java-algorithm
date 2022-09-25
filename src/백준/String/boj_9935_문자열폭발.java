package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class boj_9935_문자열폭발 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> s = new Stack<>();

        String bomb = br.readLine();

        int bomblen = bomb.length();

        for(int i=0;i<input.length();i++){
            s.push(input.charAt(i));

            if(bomblen<=s.size()){
                boolean f = true;
                for(int j=0;j<bomblen;j++){
                    if(s.get(s.size()-bomblen+j)== bomb.charAt(j))continue;
                    else {
                        f=false;
                        break;
                    }
                }
                if(f){
                    for(int j=0;j<bomblen;j++) s.pop();
                }
            }
            //System.out.println(Arrays.toString(s.toArray()));
        }

        StringBuilder ans= new StringBuilder();
        for(Character c : s){
            ans.append(c);
        }
        ans = (ans.length()==0)?ans.append("FRULA"):ans;
        System.out.println(ans);

    }
}
