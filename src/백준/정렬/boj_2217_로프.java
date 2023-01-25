package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2217_로프 {
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        Arrays.sort(arr);
        for (int i = 0; i < cnt; i++) {
            max = Math.max(max, arr[i] * (cnt - i));
        }
        System.out.println(max);


        long afterTime = System.currentTimeMillis();
        long diffTime = (afterTime - beforeTime) / 1000;
        System.out.println("[running time] "+diffTime);

    }

}
