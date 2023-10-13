package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int line = Integer.parseInt(br.readLine());
        long[][] arr = new long[line][4];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        int max = line * line;
        int index = 0;
        long[] left = new long[max];
        long[] right = new long[max];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                left[index] = arr[i][0] + arr[j][1];
                right[index++] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int leftIndex = 0;
        int rightIndex = max - 1;
        long ans = 0;

        while (leftIndex < max && 0 <= rightIndex) {
            long tempSum = left[leftIndex] + right[rightIndex];
            if (tempSum == 0) {
                long leftValue = left[leftIndex];
                long rightValue = right[rightIndex];
                int leftCount = 1;
                int rightCount = 1;

                leftIndex++;
                while (leftIndex < max && left[leftIndex] == leftValue) {
                    leftCount++;
                    leftIndex++;
                }

                rightIndex--;
                while (0 <= rightIndex && right[rightIndex] == rightValue) {
                    rightCount++;
                    rightIndex--;
                }

                ans += (long) rightCount * leftCount;
            } else if (tempSum < 0) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        System.out.println(ans);
    }
}