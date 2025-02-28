package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_5054_주차의신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int shopsCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] shops = new int[shopsCnt];

            for (int i = 0; i < shopsCnt; i++)
                shops[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(shops);

            int min = (shops[shopsCnt - 1] - shops[0]) * 2;
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}
