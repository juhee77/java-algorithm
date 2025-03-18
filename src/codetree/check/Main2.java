package codetree.check;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt() % k; // 나머지 저장
        }

        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int remainder = a[i];
            int complement = (k - remainder) % k; // 필요한 나머지 값

            // 이미 존재하는 나머지 값들과 짝을 지을 수 있는 경우 카운트 증가
            cnt += remainderCount.getOrDefault(complement, 0);

            // 현재 나머지를 해시맵에 저장
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        System.out.println(cnt);
    }
}
