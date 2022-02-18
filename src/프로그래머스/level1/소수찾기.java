package 프로그래머스.level1;

public class 소수찾기 {
    public static int solution(int n) {
        boolean prime[] = new boolean[n+1];
        prime[0]=prime[1]=true;
        int cnt=0;//2

        for(int i=2;i<=n;i++){
            if(prime[i]) continue;
            for(int j=i*i;j<=n;j+=i) prime[j]=true;
        }

        for(int i=1;i<=n;i++){
                    if(!prime[i])cnt++;
                }

        return cnt;
    }
    public static void main(String args[]){
        System.out.println(solution(10));
    }
}
