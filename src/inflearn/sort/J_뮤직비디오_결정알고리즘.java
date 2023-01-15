package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J_뮤직비디오_결정알고리즘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
        System.out.println(solution2(n,m,arr));
    }

    private static int solution(int n, int m, int[] arr) {
        //Arrays.sort(arr);
        int start = 0;
        int end = 10001;

        int ans = 10001;
        while (start <= end) {
            int mid = (start + end) >> 1;

            int cnt = checkCnt(arr, mid); //한 그룹에 mid양 만큼 들어올 수 있는 경우 몇개의 그룹으로 나뉘는지

            if (cnt <= m) {
                ans = Math.min(mid, ans);
                end = mid-1 ;
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }

    private static int checkCnt(int[] arr, int mid) {
        int cnt = 1;
        int sum = 0;
        for (int i : arr) {
            if (mid < sum+i) {
                sum = i;
                cnt++;
            } else {
                sum += i;
            }
        }
        return cnt;
    }


    public static int count(int[] arr, int capacity){
        int cnt=1, sum=0;
        for(int x : arr){
            if(sum+x>capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }
        return cnt;
    }

    public static int solution2(int n, int m, int[] arr){
        int answer=0;
        int lt= Arrays.stream(arr).max().getAsInt();
        int rt=Arrays.stream(arr).sum();
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr, mid)<=m){
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }
        return answer;
    }
}
