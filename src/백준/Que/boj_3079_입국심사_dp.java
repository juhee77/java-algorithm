package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_3079_입국심사_dp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        List<Long> arr = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(br.readLine());
            arr.add(temp);
            sum += temp;
        }
        Collections.sort(arr);
        long max = (sum / N) * M;
        long min = 0;
        //선형 탐색시 타임에러

        long mid = (max + min) / 2;
        while (min < max) {
            long pcnt = 0;
            for (Long aLong : arr) pcnt += mid / aLong;


            if (pcnt < M) min = mid;
            else {
                max = mid;
            }

            if (min + 1 == max) {
                mid = max;
                break;
            }
            mid = (max + min) / 2;
        }

        System.out.println(mid);
    }
}
