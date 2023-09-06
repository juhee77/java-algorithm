package 백준.가장긴증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11722_가장긴감소하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int lastIndex = 0;
        arr[lastIndex++] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (next < arr[lastIndex - 1]) {
                arr[lastIndex++] = next;
            } else {

                int start = 0;
                int end = lastIndex - 1;
                int mid;
                int replaceIndex = 0;
                while (start <= end) {
                    mid = (start + end) >> 1;
                    if (arr[mid] <= next) {
                        end = mid - 1;
                        replaceIndex = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                arr[replaceIndex] = next;
            }
        }
        System.out.println(lastIndex);
    }
}
