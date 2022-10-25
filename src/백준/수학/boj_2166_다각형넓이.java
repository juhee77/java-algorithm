package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2166_다각형넓이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int edge = Integer.parseInt(br.readLine());
        int arr[][] = new int[edge][2];
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        double sum = 0;

        for (int i = 0; i < edge; i++) {
            sum += (double) arr[i][0] * arr[(i + 1) % edge][1]; //casting 시에 값이 int 이면 int로 계산함
            sum -= (double)arr[i][1] * arr[(i + 1) % edge][0];
        }


        System.out.printf("%.1f", Math.abs(sum / 2));
    }
}
