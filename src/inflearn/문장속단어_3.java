package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문장속단어_3 {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int token = st.countTokens();
        String ans = "";
        for(int i=0;i<token;i++){
            String temp = st. nextToken();

            if(temp.length() > ans.length())
                ans=temp;
        }
        System.out.println(ans);
    }
}
