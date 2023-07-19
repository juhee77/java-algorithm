package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minusNums = new PriorityQueue<>();
        PriorityQueue<Integer> plusNums = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                minusNums.add(num);
            } else {
                plusNums.add(num);
            }
        }


        int sum = 0;
        while (minusNums.size() >= 2) {
            int a = minusNums.poll();
            int b = minusNums.poll();
            sum += a * b;
        }
        if (!minusNums.isEmpty()) sum += minusNums.poll();

        while (plusNums.size() >= 2) {
            int a = plusNums.poll();
            int b = plusNums.poll();
            if (a == 1 || b == 1) {
                sum += (a + b);
            } else {
                sum += a * b;
            }
        }
        if (!plusNums.isEmpty()) sum += plusNums.poll();
        System.out.println(sum);

    }
}
