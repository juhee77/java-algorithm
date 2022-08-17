package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long arr[] = new long [n];
        long max= 0;
        long min = -1;

        for(int i =0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
            max =Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        max++;
        min--;

        long temp=0;
        long ans =0;
        while(true){
            temp = (max+min)/2;
            long leg = 0;
            for(int i=0;i<n;i++){
                if(arr[i]<=temp)continue;
                leg += arr[i]-temp;
            }
//            System.out.println(min+" "+max+" "+temp + " "+leg);

            if(ans == temp) break;
            else if(leg<goal) max = temp;
            else if(leg>=goal) {
                min = ans = temp;
            }

        }

        System.out.println(ans);
    }
}
