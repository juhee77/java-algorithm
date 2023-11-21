package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1568_새 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bird = Integer.parseInt(br.readLine());

        int index = 1;
        int second = 0;
        while (0 < bird) {
            if (bird < index) {
                index = 1;
            }

            bird -= index;
            second++;
            index++;
        }

        System.out.println(second);
    }
}
