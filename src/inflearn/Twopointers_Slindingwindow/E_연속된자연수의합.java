package inflearn.Twopointers_Slindingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_연속된자연수의합 {
    //투포인터
    public int solution(int n){
        int answer=0, sum=0;
        int m=n/2+1; //중간까지만 와도 된다 두개이상의 합으로 표현되어야 하므로
        int[] arr=new int[m];
        for(int i=0; i<m; i++) arr[i]=i+1;
        int lt=0;
        for(int rt=0; rt<m; rt++){
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n) answer++;
            }
        }
        return answer;
    }

    //수학
    public int solution2(int n){
        int answer=0, cnt=1;
        n--;
        while(n>0){
            cnt++;
            n=n-cnt;
            if(n%cnt==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0, lt = 0, rt = 0;
        int cnt = 0;
        while (rt <= n) {
            sum += (++rt);
            if (sum == n && rt-lt>=1) cnt++;

            else if (sum > n) {
                while (sum > n) {
                    sum = sum - (lt++);
                }
                if (sum == n&&rt-lt>=1)  cnt++;

            }
        }
        System.out.println(cnt);
    }
}
