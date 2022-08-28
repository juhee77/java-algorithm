package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6064_카잉달력 {
    //유클리드 호제법(최대공약수)
    private static int gcd (int n,int m){
        if(m==0) return n;
        else return gcd(m,n%m);
    }
    //유클리드 호제번 (최대공배수)ㅌㅌ
    private static int lcm(int n,int m){
        return n*m/gcd(n,m);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            int lcm = lcm(M,N);
            int flag = 0;
            for(int i =x ;i<=lcm;i+=M){//첫자리 동일
                if(i%N==y){ //첫자리는 고정, 뒷자리를 모듈러 계산 으로 확인
                    sb.append(i+1).append('\n');
                    flag=1;
                    break;
                }
            }
            if(flag==0) sb.append("-1").append('\n');

        }
        System.out.println(sb);
    }
}

/*
15
40000 39999 39999 39998
40000 39999 40000 39999
40000 40000 40000 39999
40000 39998 40000 39997
39999 2 39998 2
3 40000 3 39999
40000 3 40000 3
8 2 4 2
10 12 2 12
12 10 12 10
12 10 1 1
12 6 12 6
10 1 5 1
1 10 1 5
1 1 1 1

답:
1599959999
1599960000
-1
-1
39998
39999
120000
4
12
60
1
12
5
5
1
 */