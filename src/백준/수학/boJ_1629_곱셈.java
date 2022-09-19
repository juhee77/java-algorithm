package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ_1629_곱셈 {
    private static long mod;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long cnt = Long.parseLong(st.nextToken());
        mod = Long.parseLong(st.nextToken());


        System.out.println(solution(n, cnt) % mod);
    }
}
