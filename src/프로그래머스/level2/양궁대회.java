package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/92342
import java.util.Arrays;
/*
* 처음 생각으로는 어피치의 맥스값이 경우만 피해서 화살을 맞추고 마냥 하나남은 상황에서 그 사람도 하나를 했다면 넘기고 +1을 해서
* 쏘는 방향으로 계산했는데 모든경우 계산해봐야 할것 같다.
*
* */
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
                else if(i==0 && 0<n)
                    answer[10]+=n;
            }
        }



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

        /*int []b={1,1,0,0,0,0,0,0,0,0,3};
        int[] ans2=solution(5,b);
        for(Integer ele: ans2)
            System.out.print(ele+" ");
            */

        int []b={2,2,2,2,2,0,0,0,0,0,0};
        int[] ans2=solution(10,b);
        for(Integer ele: ans2)
            System.out.print(ele+" ");
    }

}
