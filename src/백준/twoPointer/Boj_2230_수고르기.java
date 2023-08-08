package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int diffMin = Integer.parseInt(st.nextToken());

        List<Integer> arrs = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            arrs.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arrs);
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (left < a && right < a) {
            int abs = Math.abs(arrs.get(left) - arrs.get(right));
            if (abs < diffMin) {
                right++;
            } else {
                min = Math.min(min, abs);
                left++;
            }
        }
        System.out.println(min);
    }
}
