package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_11444_피보나치6 {
    private static final long mod =1000000007;
    private static HashMap<Long,Long> hash = new HashMap<>();
    public static long solution(long n){
        if(n<=0)return 0;
        System.out.println(n);
        if(hash.containsKey(n))return hash.get(n)%mod;
        if(n%2 ==0){
            long m = n/2;
            hash.put(n,solution(m)*(solution(m-1)%mod+solution(m+1)%mod)%mod);
            return hash.get(n);
        }
        else{
            long m = (n-1)/2;
            hash.put(n,(solution(m)*solution(m)%mod+solution(m+1)*solution(m+1)%mod)%mod);
            return hash.get(n);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hash.put((long)0,(long)0);
        hash.put((long)1,(long)1);
        hash.put((long)2,(long)1);
        hash.put((long)3,(long)2);
        hash.put((long)4,(long)3);
        hash.put((long)5,(long)5);
        long n = Long.parseLong(br.readLine());
        System.out.println(solution(n)%mod);
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    private static final long mod =1000000007;
    private static HashMap<Long,Long> hash = new HashMap<>();
    public static long solution(long n){
        if(n<=0)return 0;
        if(hash.containsKey(n))return hash.get(n)%mod;
        if(n%2 ==0){
            long m = n/2;
            long mvalue = hash.getOrDefault(m,solution(m)%mod);
            long m_1value = hash.getOrDefault(m-1,solution(m-1)%mod);
            long m1value = hash.getOrDefault(m+1,solution(m+1)%mod);
            hash.put(m,mvalue);
            hash.put(m-1,m_1value);
            hash.put(m+1,m1value);

            return mvalue*((m_1value+m1value)%mod)%mod;
        }
        else{
            long m = (n-1)/2;
            long mvalue = hash.getOrDefault(m,solution(m)%mod);
            long m1value = hash.getOrDefault(m+1,solution(m+1)%mod);
            hash.put(m,mvalue);
            hash.put(m+1,m1value);

            return (mvalue*mvalue%mod+m1value*m1value%mod)%mod;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hash.put((long)0,(long)0);
        hash.put((long)1,(long)1);
        hash.put((long)2,(long)1);
        hash.put((long)3,(long)2);
        hash.put((long)4,(long)3);
        hash.put((long)5,(long)5);
        long n = Long.parseLong(br.readLine());
        System.out.println(solution(n)%mod);
    }
}
t
 */