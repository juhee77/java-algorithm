package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_17451_평행우주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long now = arr[n - 1];
        for (int i = n - 2; 0 <= i; i--) {
            if (arr[i] > now) now = arr[i];
            else {
                if (now % arr[i] != 0)
                    now = (now / arr[i] + 1) * arr[i];
            }
        }
        System.out.println(now);
    }

}
