package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_뒤집은소수 {
    static int prime[] = new int[100001];
    public static void solution1() { //런타임 에러 나는경우 sqrt +1 or 자료형 바꾸기!!!!
        int n=100000;
        prime[0] = prime[1] = 1;
        int cnt = 0;//2

        for (int i = 2; i < Math.sqrt(n) + 1; i++) { //제곱근 만큼 돌아도 계산 가능
            if (prime[i] == 1) continue;
            for (int j = i * i; j < n + 1; j += i) prime[j] = 1; //에라토스 테네스의 체 사용
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        solution1();

        for(int i=0;i<num;i++){
            StringBuffer temp = new StringBuffer(st.nextToken());
            int tempNum = Integer.parseInt(String.valueOf(temp.reverse()));
            if(prime[tempNum]==0)sb.append(tempNum+" ");
        }
        System.out.println(sb);
    }
}
