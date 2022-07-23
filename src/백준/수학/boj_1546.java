package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int sum=0;
        st = new StringTokenizer(br.readLine());

        int prime[] = new int[1001];
        prime[0]=prime[1]=1;
        int cnt=0;//2

        for(int i=2;i<Math.sqrt(1001);i++){ //제곱근 만큼 돌아도 계산 가능
            if(prime[i]==1) continue;
            for(int j=i*i;j<1001;j+=i) prime[j]=1; //에라토스 테네스의 체 사용
        }


        for(int i=0;i<size;i++){
            int temp=Integer.parseInt(st.nextToken());
            if(prime[temp]==0)cnt++;
        }


        System.out.println(cnt);

    }
}
