package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10986_메모리최적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int divisor = Integer.parseInt(st.nextToken());
        int ans = 0;
        long arr[] = new long[cnt+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            int now = Integer.parseInt(st.nextToken());

            for (int j = i; 1<= j; j--) {
                arr[j] = arr[j-1] + now;
                //System.out.println(Arrays.toString(arr));
                if (arr[j] % divisor == 0) ans++;
            }
            //System.out.println();
            //System.out.println();

        }
        sb.append(ans);
        System.out.println(sb);

    }
}
