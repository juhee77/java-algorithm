package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/92342
import java.util.Arrays;

public class 양궁대회 {
    public static int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        int[] copyinfo= info.clone();//깊은복사 값이 저장된다
        Arrays.sort(copyinfo);
        int max=copyinfo[info.length-1];
        //System.out.println(max);
        int appeachScore=0, ryanScore=0;

        for(int i=10;0<=i;i--){
            if(info[10-i]==max) {
                appeachScore += i;
                System.out.println(i+" "+appeachScore);
            }

            else{
                if(n<=info[10-i]&&1<=info[10-i]){
                    appeachScore+=i;
                }
                else if(n>0){
                    answer[10-i]=info[10-i]+1;
                    n -= info[10-i]+1;
                    ryanScore+=i;
                }
            }
        }

        if(0<n)
            answer[10]+=n;

        System.out.println(ryanScore+" "+appeachScore);
        if(ryanScore<=appeachScore){

            int []ad=new int[] {-1};
            return ad;
        }

        return answer;
    }

    public static void main(String args[]){
        int []a={2,1,1,1,0,0,0,0,0,0,0};
        int[] ans=solution(5,a);
        for(Integer ele: ans)
            System.out.println(ele);
    }
}
