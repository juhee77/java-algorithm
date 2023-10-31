package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2476_주사위게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int max = 0;
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int temp;
            if (a == b || b == c || a == c) {
                if (a == b && b == c) {
                    temp = 10_000 + a * 1000;
                } else {
                    if (a == b || a == c) {
                        temp = 1000 + a * 100;
                    } else {
                        //b == c
                        temp = 1000 + b * 100;
                    }
                }
            } else {
                temp = Math.max(Math.max(a, b), c) * 100;
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
