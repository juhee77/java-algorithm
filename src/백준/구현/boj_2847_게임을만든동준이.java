package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2847_게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int before = arr[n - 1];
        int sum = 0;
        for (int i = n - 2; 0 <= i; i--) {
            if (arr[i] >= before) {
                sum += (arr[i] - before + 1);
                before = before - 1;
            } else {
                before = arr[i];
            }
        }
        System.out.println(sum);
    }
}
