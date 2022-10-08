package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_7579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());


        int get[] = new int[n];
        int pay[] = new int[n];

        /*입력*/
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) get[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pay[i] = Integer.parseInt(st.nextToken());


        int all[][] = new int[n + 1][100001];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (pay[i - 1] <= j) all[i][j] = Math.max(all[i - 1][j - pay[i - 1]] + get[i - 1], all[i - 1][j]);
                else all[i][j] = all[i - 1][j];

                if(all[i][j]>=goal) ans = Math.min(ans,j);
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= 7; j++) {
//                System.out.print(all[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(ans);
    }
}
