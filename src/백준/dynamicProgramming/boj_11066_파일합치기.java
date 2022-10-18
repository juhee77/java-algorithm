package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11066_파일합치기 {
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            K = Integer.parseInt(br.readLine());
            int all[][] = new int[K +1][K +1];
            int sum[] = new int[K +1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(sum,0);
            for(int i = 1; i<= K; i++){
                sum[i]=Integer.parseInt(st.nextToken())+sum[i-1];
            }
            for(int i = 1; i<= K; i++){
                for(int j = 1; j<= K -i; j++){
                    all[j][i+j]=(int)1e8;
                    for(int p=j;p<i+j;p++){
                        all[j][i+j] = Math.min(all[j][i+j],all[j][p]+all[p+1][i+j]+sum[i+j]-sum[j-1]);
                    }
                }
            }

//            for(int i = 1; i<= K; i++){
//                System.out.println(Arrays.toString(all[i]));
//            }
            sb.append(all[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}
