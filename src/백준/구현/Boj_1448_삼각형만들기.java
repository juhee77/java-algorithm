package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_1448_삼각형만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr);
        int max = -1;
//        System.out.println(arr);
        for (int i = n - 1; 2 <= i; i--) {
            if (arr.get(i) < arr.get(i - 1) + arr.get(i - 2)) {
                max = Math.max(max, arr.get(i) + arr.get(i - 1) + arr.get(i - 2));
                break;
            }
        }
        System.out.println(max);
    }
}