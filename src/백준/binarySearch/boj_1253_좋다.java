package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;

            while (start < end) {
                if (start == i || end == i) { //본인 이라면
                    if (start == i) start++;
                    else end--;
                } else {
                    int now = arr[start] + arr[end];
                    if (arr[i] == now) {
                        cnt++;
                        break;
                    } else if (now < arr[i]) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        System.out.println(cnt);

        //3%오류 -> 음수에 대한 고려
        //60 %오류 -> 0에 대한 고려
    }
}
