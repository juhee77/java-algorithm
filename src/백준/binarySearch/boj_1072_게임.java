package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = (y * 100 / x);


        if (x == y || z==99) System.out.println(-1);
        else {
            long start = 1;
            long end = x;
            long ans = 0;
            while (start <= end) {
                long mid = (start + end) >> 1;
                long temp = (y + mid) * 100 / (x + mid);
                if (temp >= z + 1) {
                    end = mid - 1;
                    ans = mid;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(ans);
        }

    }
}
