package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class 가장짧은문자거리_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String cpy = st.nextToken();
        Character match = st.nextToken().charAt(0);
        int last=0;
        for (int i = 1; i <= cpy.length(); i++) {
            if(cpy.charAt(i-1)==match) {
                sb.append("0 ");
                last = i;
                continue;
            }
            int a = cpy.substring(i-1).indexOf(match);
            int b = (last==0)?-1:i-last;

            if( a>=0 && b>=0 ) sb.append(Math.min(a,b)+" ");
            else if( a>= 0) sb.append(a+" ");
            else if( b>=0 )sb.append(b+" ");
            else sb.append(" ");
        }

        System.out.println(sb);
    }
}
