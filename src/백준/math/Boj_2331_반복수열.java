package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2331_반복수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<Long, Integer> set = new HashMap<>();
        int index = 1;
        set.put(a, index++);
        while (true) {
            long sum = 0;
            while (0 < a) {
                sum += Math.pow(a % 10, b);
                a /= 10;
            }

            if (set.containsKey(sum)) {
                System.out.println(set.get(sum) - 1);
                return;
            } else {
                set.put(sum, index++);
            }
            a = sum;
        }
    }
}
