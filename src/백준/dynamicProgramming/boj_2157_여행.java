package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2157_여행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] time = new int[m + 1][n + 1]; //n번 도시에서 끝나야 한다.
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (end <= start) continue;

            int point = Integer.parseInt(st.nextToken());
            arr.add(new int[]{start, end, point});
        }

        arr.sort(Comparator.comparingInt(o -> o[0]));

        for (int[] ints : arr) {
            int start = ints[0];
            int end = ints[1];
            int point = ints[2];

            //처음 비행기를 타고 움직이는 경우
            if (start == 1) time[2][end] = Math.max(point, time[2][end]);

            else {
                for (int p = 3; p <= m; p++) {
                    //해당 비행기를 타는 경우에 대해서
                    if (time[p - 1][start] == 0) continue;//여기까지 올 수 있는 비행기가 없다.
                    time[p][end] = Math.max(time[p][end], time[p - 1][start] + point);
                }
            }

        }

        int max = 0;
        for (int i = 0; i <= m; i++) {
            max = Math.max(max, time[i][n]);
        }

        System.out.println(max);
    }
}
/*
3 3 5
1 2 10
1 3 20
2 3 20
1 3 5
2 3 40
50
 */