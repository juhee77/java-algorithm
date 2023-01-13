package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1057_토너먼트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sz = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;

        if (b < a) {
            int temp = b;
            b = a;
            a = temp;
        }

        while (0 < sz) {
            if ((a % 2 == 1) && a + 1 == b) {
                break;
            }

            a = (int) Math.round((double) a / 2);
            b = (int) Math.round((double) b / 2);
            cnt++;
            sz /= 2;
        }
        System.out.println(cnt);
    }
}
