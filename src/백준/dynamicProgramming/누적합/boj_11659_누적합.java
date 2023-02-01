package 백준.dynamicProgramming.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(st.nextToken());
        int arr[] = new int[numberCount+1];
        int sum[] = new int[numberCount+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=numberCount;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i]= arr[i]+sum[i-1];
            //누적합 i 번 까지의 모든 수의 합
            // 이걸 이용하여 end 까지의 합에서 start 전까지의 합을 더함
        }

        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int tempsum=sum[end]-sum[start-1];
            sb.append(tempsum).append('\n');
        }
        System.out.println(sb);

    }
}
