package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2592_대표값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] set = new int[1000 / 10 + 1];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            set[num / 10]++;
        }
        int maxNum = 0;
        for (int i = 1; i < set.length; i++)
            if (set[i] > set[maxNum])
                maxNum = i;

        System.out.println(sum / 10 + "\n" + (maxNum * 10));
    }
}
