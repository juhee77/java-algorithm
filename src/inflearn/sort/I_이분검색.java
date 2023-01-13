package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I_이분검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n,m,arr));
        System.out.println(solution2(n,m,arr));
    }

    private static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid =(start+end)>>1;

            if(arr[mid]==m) return mid+1;

            if(arr[mid]<m) {
                start = mid+1;
            }
            else if(m<arr[mid]){
                end=mid-1;
            }
        }
        return -1;
    }

    public static int solution2(int n, int m, int[] arr){
        int answer=0;
        Arrays.sort(arr);
        int lt=0, rt=n-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==m){
                answer=mid+1;
                break;
            }
            if(arr[mid]>m) rt=mid-1;
            else lt=mid+1;
        }
        return answer;
    }

}
