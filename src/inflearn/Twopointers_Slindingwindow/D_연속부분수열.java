package inflearn.Twopointers_Slindingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_연속부분수열 {
    public static int solution(int n, int m, int[] arr){
        //sum에 lt 부터 rt 까지의합 작으면 rt 가 증가 , 크면 lt+1 하고 앞에 제거하고 뒤에거 추가하면 같는지를 확인
        int answer=0, sum=0, lt=0; ///lt = left rt=right
        for(int rt=0; rt<n; rt++){
            sum+=arr[rt];
            if(sum==m) answer++;
            while(sum>=m){
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int[] sum = new int[num];

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
//        int ans=0;
//        for (int i=0; i<num;i++){
//            for(int j=1;j<=num;j++){
//                sum[j-1] += arr[i];
//                if(j-1<i) sum[j-1] -= arr[i-j];
//                if(sum[j-1]==goal) ans++;
//            }
//            //System.out.println(i+"  "+Arrays.toString(sum));
//        }
//        System.out.println(ans);

        System.out.println(solution(num,goal,arr));
    }
}
