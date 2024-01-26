package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1027_고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;

            for (int j = i - 1; 0 <= j; j--) {
                if (isAble(arr, i, j)) {
                    temp++;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (isAble(arr, j, i)) {
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }

    private static boolean isAble(int[] arr, int i, int j) {
        double increaseX = i - j;
        double increaseY = arr[i] - arr[j];

        double range = increaseY / increaseX;
        double k = arr[j] - range * j;


        for (int p = j + 1; p < i; p++) {
            if (arr[p] >= range * p + k) {
                return false;
            }
        }

        return true;
    }
}
