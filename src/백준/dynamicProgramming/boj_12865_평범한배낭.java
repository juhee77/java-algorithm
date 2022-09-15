package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int arr[][] = new int[line + 1][goal + 1];

        for (int ele = 1; ele <= line; ele++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(weight<goal) arr[ele][weight] = Math.max(arr[ele - 1][weight], value);
            for (int i = 0; i <= goal; i++) {
                if (arr[ele - 1][i] != 0) {
                    arr[ele][i] = Math.max(arr[ele - 1][i], arr[ele][i]);
                    if (i + weight <= goal)
                        arr[ele][i + weight] = Math.max(arr[ele - 1][i + weight], arr[ele - 1][i] + value);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= goal; i++) {
            max = Math.max(max, arr[line][i]);
        }
        System.out.println(max);
    }
}
