package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12921
public class 소수찾기 {
    public static int solution(int n){
        int prime[] = new int[n+1];
        prime[0]=prime[1]=1;
        int cnt=0;//2

        for(int i=2;i<Math.sqrt(n);i++){ //제곱근 만큼 돌아도 계산 가능
            if(prime[i]==1) continue;
            for(int j=i*i;j<n+1;j+=i) prime[j]=1; //에라토스 테네스의 체 사용
        }

        for(int i=1;i<n+1;i++)
            if(prime[i]==0)cnt++;

        return cnt;
    }

    public int solution1(int n){ //런타임 에러 나는경우 sqrt +1 or 자료형 바꾸기!!!!
        int prime[] = new int[n+1];
        prime[0]=prime[1]=1;
        int cnt=0;//2

        for(int i=2;i<Math.sqrt(n)+1;i++){ //제곱근 만큼 돌아도 계산 가능
            if(prime[i]==1) continue;
            for(int j=i*i;j<n+1;j+=i) prime[j]=1; //에라토스 테네스의 체 사용
        }

        for(int i=1;i<n+1;i++)
            if(prime[i]==0)cnt++;

        return cnt;
    }
    public static int solution2(int n) {
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
