package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int goalMoney = Integer.parseInt(br.readLine());
            int[] coinMap = new int[goalMoney + 1];

            coinMap[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= goalMoney; j++) {
                    if (j - arr[i] >= 0) coinMap[j] += coinMap[j - arr[i]];
                }
            }

            sb.append(coinMap[goalMoney]).append("\n");
        }
        System.out.println(sb);
    }
}
