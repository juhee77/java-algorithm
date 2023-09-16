package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj_2295_세수의합 {
    private static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                nums.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(nums);
        for (int k = n - 1; 0 <= k; k--) {
            for (int z = k; 0 <= z; z--) {
                int value = arr[k] - arr[z];

                if (-1 < Collections.binarySearch(nums, value)) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }
}
