package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13305_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int city = Integer.parseInt(br.readLine());
        long oilPrice[] = new long[city];
        long needOil[] = new long[city - 1];

        long minPrice = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city - 1; i++) {
            needOil[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }


        long ans = 0;
        for(int i=0;i<city-1;i++){
            minPrice = Math.min(oilPrice[i],minPrice );
            ans += minPrice*needOil[i];
        }

        sb.append(ans);
        System.out.println(sb);
    }
}
