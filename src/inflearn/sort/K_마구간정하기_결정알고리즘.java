package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K_마구간정하기_결정알고리즘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, c, arr));
        System.out.println(solution2(n, c, arr));

    }

    private static int solution(int n, int c, int[] arr) {
        int start = 0;
        int end = 1000000001;
        int ans =0;
        Arrays.sort(arr);

        while (start <= end) {
            int mid = (start + end) >> 1;
            int cnt = checkCnt(arr, mid);
            if(cnt<c){
                end = mid-1;
            }
            else{
                ans = Math.max(ans, mid);
                start=mid+1;
            }
        }
        return ans;
    }

    private static int checkCnt(int[] arr, int mid) {
        int start = arr[0];
        int cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            if(mid <= now-start){
                cnt++;
                start = now;
            }
        }
        return cnt;
    }

    public static int count(int[] arr, int dist){
        int cnt=1;
        int ep=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep>=dist){
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    public static int solution2(int n, int c, int[] arr){
        int answer=0;
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr, mid)>=c){
                answer=mid;
                lt=mid+1;
            }
            else rt=mid-1;
        }
        return answer;
    }
}
