package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13172_sigma {
    private static final long mod =1000000007;

    private static long solution(long n, long cnt){
        if(cnt ==1 )return n%mod;
        if(cnt%2==1){
            long temp = solution(n,(cnt-1)/2)%mod;
            return temp*temp%mod*(n%mod);
        }
        else {
            long temp = solution(n,cnt/2)%mod;
            return temp*temp%mod;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int line =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long ans = 0;

        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
            long ni = Long.parseLong(st.nextToken());
            long si = Long.parseLong(st.nextToken());


            long x = solution(ni,mod-2);
            ans+=x*si%mod;
            ans%=mod;

        }

        System.out.println(ans);

    }
}
