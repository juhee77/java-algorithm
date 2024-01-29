package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10810_공넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int bucketSize = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[] buckets = new int[bucketSize];


        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ballNum = Integer.parseInt(st.nextToken());
            for (int j = start - 1; j < end; j++) {
                buckets[j] = ballNum;
            }
        }

        for (int ball : buckets) {
            sb.append(ball).append(" ");
        }
        System.out.println(sb);
    }
}
