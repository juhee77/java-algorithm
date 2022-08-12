package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2609_최대공약수최소공배수 {
    public static int[] solution(int n, int m) {
        int max = (n > m) ? n : m;
        int min = (n > m) ? m : n;
        int i = 1;

        while (true)
            if (min * (i++) % max == 0)
                break;

        for (; max > 0; max--)
            if (n % max == 0 && m % max == 0)
                break;

        return new int[]{max, min * (i - 1)};
    }

    //유클리드 호제법(최대공약수)
    public  int gcd (int n,int m){
        if(m==0) return n;
        else return gcd(m,n%m);
    }
    //유클리드 호제번 (최대공배수)
    public int lcm(int n,int m){
        return n*m/gcd(n,m);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int arr[] = solution(a, b);
        System.out.println(arr[0] + "\n" + arr[1]);

        boj_2609_최대공약수최소공배수 s = new boj_2609_최대공약수최소공배수();
        System.out.println(s.lcm(a,b)+" "+s.gcd(a,b));
    }
}

