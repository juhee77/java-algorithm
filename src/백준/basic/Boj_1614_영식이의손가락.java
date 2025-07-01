package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1614_영식이의손가락 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int broken = Integer.parseInt(br.readLine());
        int maxUse = Integer.parseInt(br.readLine());

        int[] fingers = {1, 2, 3, 4, 5, 4, 3, 2};
        int idx = 0;
        int count = 0;
        int used = 0;

        while (true) {
            int finger = fingers[idx];
            if (finger == broken) {
                if (used >= maxUse) break;
                used++;
            }
            count++;
            idx = (idx + 1) % fingers.length;
        }
        System.out.println(count);
    }
}
