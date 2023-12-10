package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3515_합이0_2 {

    static int N;
    static long ans;
    static int[] num;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // Input
            readInput(br);

            // Sort the array
            Arrays.sort(num);

            // Count triplets with zero sum
            countTripletsWithZeroSum();

            // Output the result
            bw.write(ans + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readInput(BufferedReader br) throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        num = new int[N];
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void countTripletsWithZeroSum() {
        for (int i = 0; i < N - 2; ++i) {
            for (int j = i + 1; j < N - 1; ++j) {
                int key = -(num[i] + num[j]);
                int l = lowerBound(j + 1, N, key);

                if (l == N || num[l] != key) continue;

                int r = upperBound(j + 1, N, key);
                ans += r - l;
            }
        }
    }

    static int lowerBound(int l, int r, int key) {
        int mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (num[mid] >= key) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    static int upperBound(int l, int r, int key) {
        int mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (num[mid] > key) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
