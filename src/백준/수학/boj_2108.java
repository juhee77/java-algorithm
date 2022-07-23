package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt[]=new int[8001];
        int max=-4000,min=4000;
        int maxCnt=0;
        int cntSum =0;
        double avg=0;

        int n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(br.readLine());
            cnt[temp+4000]++;
            if(cnt[maxCnt]<cnt[temp+4000]) maxCnt=temp+4000; //최빈
            if(max<=temp) max=temp;
            if(temp<=min) min=temp;
            avg+=temp;
        }

        int cntflag=0;
        int flag=0;
        for(int i=min+4000;i<=max+4000;i++){
            if(cntflag<2&&cnt[maxCnt]==cnt[i]){
                cntflag++;
                maxCnt=i;
            }
            if(flag<1) {
                cntSum += cnt[i];
                if(cntSum>=(int)(n+1)/2){
                    flag++;
                    cntSum = i;
                }
            }
            if(flag==1 && cntflag==2) break;
        }

        System.out.println(Math.round(avg/n));
        System.out.println(cntSum-4000);
        System.out.println(maxCnt-4000);
        if(n==1)System.out.println(0);
        else System.out.println(max-min);

    }
}
