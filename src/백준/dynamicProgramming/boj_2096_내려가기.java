package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        long maxArr[] = new long[3];
        long maxArrTemp[] = new long[3];
        long minArr[] = new long[3];
        long minArrTemp[] = new long[3];

        long max = 0;
        long min = Integer.MAX_VALUE;

        for (int i = 1; i <= line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());
            maxArrTemp[0]= Math.max(maxArr[0],maxArr[1])+temp;
            minArrTemp[0] = Math.min(minArr[0],minArr[1])+temp;

            temp = Integer.parseInt(st.nextToken());
            maxArrTemp[1]= Math.max(maxArr[2],Math.max(maxArr[0],maxArr[1]))+temp;
            minArrTemp[1] = Math.min(minArr[2],Math.min(minArr[0],minArr[1]))+temp;

            temp = Integer.parseInt(st.nextToken());
            maxArrTemp[2]= Math.max(maxArr[2],maxArr[1])+temp;
            minArrTemp[2] = Math.min(minArr[2],minArr[1])+temp;


//            for (int j = 1; j <= 3; j++) {
//                int temp = Integer.parseInt(st.nextToken());
//                maxArrTemp[j] = Math.max(Math.max(maxArr[j - 1], maxArr[j]), maxArr[j + 1]) + temp;
//                minArrTemp[j] = Math.min(Math.min(minArr[j - 1], minArr[j]), minArr[j + 1]) + temp;
//            }
            maxArr=maxArrTemp.clone();
            minArr=minArrTemp.clone();
        }

        for(int i=0;i<=2;i++){
            max = Math.max(maxArr[i],max);
            min = Math.min(minArr[i],min);
        }
        sb.append(max+" "+min);
        System.out.println(sb);
    }
}
