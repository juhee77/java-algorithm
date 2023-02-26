package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10090_CountingInversions {
    private static long[] arr;
    private static long[] temp;
    private static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        temp = new long[n];
        ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        //merge sort 의 비교횟수
        mergeSort(0, n - 1);
        System.out.println(ans);
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int index = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && arr[p] < arr[q])) {
                    temp[index++] = arr[p++];
                } else {
                    ans += mid - p + 1;
                    temp[index++] = arr[q++];
                }
            }

            if (end + 1 - start >= 0) System.arraycopy(temp, start, arr, start, end + 1 - start);
        }
    }
}
