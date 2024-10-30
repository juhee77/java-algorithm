package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1476_날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int year = 1;
        int x = 1, y = 1, z = 1;
        while (x != a || y != b || z != c) {
            x++;
            y++;
            z++;
            if (15 < x) x = 1;
            if (28 < y) y = 1;
            if (19 < z) z = 1;
            year++;
        }

        System.out.println(year);
    }
}
