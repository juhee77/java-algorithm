package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        if (a.length() == b.length()) {
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        else{
            int min = 10000;
            for (int i = 0; i < b.length() - a.length() + 1; i++) {
                int tempMin = 0;
                for (int j = 0; j < a.length(); j++) {
                    if (a.charAt(j) != b.charAt(i + j)) {
                        tempMin++;
                    }
                }
                min = Math.min(min, tempMin);
            }
            System.out.println(min);
        }
    }
}
