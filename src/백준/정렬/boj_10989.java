package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Integer.parseInt(br.readLine());
        int count[] = new int[10001];

        for (long k = 0; k < n; k++) {
            int temp = Integer.parseInt(br.readLine());
            count[temp]++;
        }

        for (int i = 0; i < 10001; i++)
            for (int j = 0; j < count[i]; j++)
                sb.append(i).append("\n");

        System.out.println(sb);

    }
}
