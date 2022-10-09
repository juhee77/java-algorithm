package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(br.readLine());
        int arr[][] = new int[day + 1][day + 1];
        for (int i = 1; i <= day; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= day; j++) {
                if(i+time-1==j)arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-time]+pay);
                else arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
            }
        }
        System.out.println(arr[day][day]);

    }
}
