package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ///int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target =Integer.parseInt(st.nextToken());
        int ans = 0;

        int arr[] =new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int tempSum = arr[i]+arr[j]+arr[k];
                    if(tempSum==target) ans = tempSum;
                    else if (tempSum<target){
                        ans = (target-ans>=target-tempSum)? tempSum : ans;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
