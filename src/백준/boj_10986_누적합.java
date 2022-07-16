package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10986_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int divisor = Integer.parseInt(st.nextToken());
        int ans = 0;
        int arr[][] = new int[cnt+1][cnt + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            int now = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i-1][j-1] + now;
                //System.out.println(Arrays.toString(arr[i]));
                if (arr[i][j] % divisor == 0) ans++;
            }
            //System.out.println();
            //System.out.println();

        }
        sb.append(ans);
        System.out.println(sb);

    }
}
