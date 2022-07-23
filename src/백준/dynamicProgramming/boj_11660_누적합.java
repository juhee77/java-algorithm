package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11660_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        int arr[][] = new int[cnt+1][cnt + 1];


        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= cnt; j++) {
                arr[i][j]= arr[i-1][j]+arr[i][j-1]+Integer.parseInt(st.nextToken())-arr[i-1][j-1];
            }
            //System.out.println(Arrays.toString(arr[i]));
        }

        for (int TC = 1; TC <= line; TC++){
            st = new StringTokenizer(br.readLine());
            int x1= Integer.parseInt(st.nextToken());
            int y1= Integer.parseInt(st.nextToken());
            int x2= Integer.parseInt(st.nextToken());
            int y2= Integer.parseInt(st.nextToken());

            //System.out.println(arr[x2][y2]+" "+arr[x1-1][y1]+" "+arr[x1][y1-1]+" "+arr[x1-1][y1-1]);
            sb.append(arr[x2][y2]-arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1]).append('\n');
        }

        System.out.println(sb);

    }
}
