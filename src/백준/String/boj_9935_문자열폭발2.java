package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9935_문자열폭발2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> s = new Stack<>();

        String bomb = br.readLine();

        int bomblen = bomb.length();
        char last = bomb.charAt(bomblen-1);

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            s.push(c);

            if(c==last && bomblen<=s.size()){
                boolean f = true;
                for(int j=0;j<bomblen;j++){
                    if(s.get(s.size()-j-1)== bomb.charAt(bomblen-j-1))continue;
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

        //stringbuilder 사용안하며 메모리 초과요류남
        ans = (ans.length()==0)?ans.append("FRULA"):ans;
        System.out.println(ans);

    }
}
