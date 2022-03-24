package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12924 -- 숫자의 표현 <0325>
public class showNum {
    public int solution(int n) {
        int answer = 0;
        int[] eachSum = new int[n];
        int point=0;
        for(int i=0;i<n;i++){
            for(int j=point;j<=i;j++){
                eachSum[j]+=i+1;
                //System.out.print(eachSum[j]+"  ");
                if(eachSum[j] ==n ) answer++;
                if(eachSum[j] >= n) point++;
            }
            //System.out.println();
        }
        return answer;
    }
    public static void main(String args[]){
        System.out.println(new showNum().solution(15));
    }
}
