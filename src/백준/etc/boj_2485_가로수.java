package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_2485_가로수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());
        List<Integer> points = new ArrayList<>();
        while (line-- > 0) {
            points.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(points);
        //최소 공약수
        int min = points.get(1) - points.get(0);
        for (int i = 1; i < points.size() - 1; i++) {
            int gcd = gcd(min, points.get(i + 1) - points.get(i));
            min = Math.min(min, gcd);
        }

        int cnt = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            cnt += (points.get(i + 1) - points.get(i)) / min - 1;
        }
        System.out.println(cnt);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
