package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16401_과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //막대 과자는 여러조각으로 나눠질 수 있지만 하나로 합칠수는 없다
        //모든 조카에게 같은 길이의 막대과자를 나눠 주어야 한다.

        st = new StringTokenizer(br.readLine());
        int siblilingCnt = Integer.parseInt(st.nextToken()); //조카의 수
        int snackCnt = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = 0;
        int[] arr = new int[snackCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < snackCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if(mid==0){
                min++;
                continue;
            }

            int ableStickCnt = 0;
            for (int i : arr) {
                ableStickCnt += i / mid;
            }

            if (ableStickCnt < siblilingCnt) {
                max = mid - 1;
            } else {
                ans = mid;
                min = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
