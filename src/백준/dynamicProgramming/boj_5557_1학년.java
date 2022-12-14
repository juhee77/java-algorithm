package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sz = Integer.parseInt(br.readLine()) - 1;
        st = new StringTokenizer(br.readLine());
        int[] num = new int[sz];

        for (int i = 0; i < sz; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int goal = Integer.parseInt(st.nextToken());

        long[] nowMap = new long[21];

        nowMap[num[0]] ++;

        for(int i=1;i<sz;i++){
            long[] nextMap = new long[21];

            int nowNum = num[i];
            for(int j=0;j<21;j++){
                if(20 >= j +nowNum)  {
                    nextMap[j+nowNum] += nowMap[j];
                }
                if(0 <= j-nowNum) {
                    nextMap[j-nowNum] += nowMap[j];
                }
            }
            nowMap=nextMap.clone();
        }

        System.out.println(nowMap[goal]);
    }
}
