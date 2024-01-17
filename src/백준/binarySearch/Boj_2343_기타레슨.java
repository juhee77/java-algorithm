package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int nax = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nax = Math.max(nax, arr[i]);
        }

        int start = nax;
        int end = (int)(1e8);
        int mid = (start + end) >> 1;
        int ans = mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int temp = 0;
            int useCnt = 0;

            for (int i = 0; i < n; i++) {
                temp += arr[i];

                if (mid <= temp) {
                    if (mid == temp) {
                        temp = 0;
                    } else {
                        temp = arr[i];
                    }
                    useCnt++;
                }
            }
            if (temp > 0) {
                useCnt++;
            }

            if (useCnt <= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
