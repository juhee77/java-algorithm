package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2559_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int arr[] = new int[numberCount+1];
        int cpy[] = new int[numberCount+1];
        int max=0;

        st = new StringTokenizer(br.readLine());
        int j=1;
        for(int i=1;i<=numberCount;i++){
            cpy[i]=Integer.parseInt(st.nextToken());

            if(i<=day) {
                arr[i]=arr[i-1]+cpy[i];
                if(i==day) max=arr[i];
            }
            else  {
                arr[i]=arr[i-1]+cpy[i]-cpy[j++];
                max=Math.max(max,arr[i]);
            }
        }

        //System.out.println(Arrays.toString(arr));
        sb.append(max);
        System.out.println(sb);

    }
}
