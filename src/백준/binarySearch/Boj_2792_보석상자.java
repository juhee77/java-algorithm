package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2792_보석상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int peopleCounts = Integer.parseInt(st.nextToken());
        int color = Integer.parseInt(st.nextToken());

        int[] colors = new int[color];
        int max = 0;
        for (int i = 0; i < color; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, colors[i]);
        }

        int start = 1;
        int end = max;
        int ans = end;

        while (start < end) {
            int mid = (start + end) / 2;

            int count = 0;
            for (int c : colors) {
                count += c / mid;
                if (c % mid > 0) count++;
                if (count > peopleCounts) break;
            }
//            System.out.println(start+" "+end+" "+mid+" "+count);

            if (count > peopleCounts) {
                start = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                end = mid;
            }
//            idx++;
        }
        System.out.println(ans);
    }
}
