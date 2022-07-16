package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16139_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String s = br.readLine();
        int numberCount = s.length();
        char input[] = s.toCharArray();
        int arr[][] = new int[26][numberCount+1];


        for(int i=1;i<=numberCount;i++){
            int temp = input[i-1];
            for(int j=0;j<26;j++){
                if(j==(temp-97))  arr[j][i] = arr[j][i-1]+1;
                else arr[j][i] = arr[j][i-1];
            }
        }

        int TC= Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //System.out.println(a+" "+start+" "+end);
            sb.append(arr[a-97][end+1]-arr[a-97][start]).append('\n');

        }

        System.out.println(sb);

    }
}
