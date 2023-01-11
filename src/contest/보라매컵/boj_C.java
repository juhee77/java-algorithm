package contest.보라매컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int line = Integer.parseInt(br.readLine());
        int[][] arr = new int[line][2];
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int endDay = Integer.parseInt(st.nextToken());
            int costTime = Integer.parseInt(st.nextToken());
            arr[i][0] = endDay;
            arr[i][1] = costTime;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));


        int time = 0;
        int[] mi = {0,2,4,6,8,10,11,12};
        int[] exceed = {0,1,2,3,4,5,0};
        int availableTime;
        for (int i = 0; i < line; i++) {
            time += arr[i][1];
             availableTime = (arr[i][0] / 7) * mi[7] + mi[arr[i][0] % 7];
            if (availableTime < time) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(Math.max(0, time-(arr[line-1][0]/7*5+Math.min(5,arr[line-1][0]%7))));
    }
}
