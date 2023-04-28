package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1105_팔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] start = st.nextToken().toCharArray();
        char[] end = st.nextToken().toCharArray();

        int cnt = 0;

        if (start.length == end.length) {
            for (int i = 0; i < start.length; i++) {
                if (start[i] == end[i]) {
                    if (start[i] == '8') {
                        cnt++;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
