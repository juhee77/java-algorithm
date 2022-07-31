package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1929_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        int prime[] = new int[end+1];
        prime[0]=prime[1]=1;
        int cnt=0;//2

        for(int i=2;i<Math.sqrt(end)+1;i++){ //제곱근 만큼 돌아도 계산 가능
            if(prime[i]==1) continue;
            for(int j=i*i;j<end+1;j+=i) prime[j]=1; //에라토스 테네스의 체 사용
        }


        for(int i=start;i<=end;i++){
            if(prime[i]==0)sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}
