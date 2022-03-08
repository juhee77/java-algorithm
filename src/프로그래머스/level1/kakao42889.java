package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class kakao42889 {
    public int[] solution(int N, int[] stages) {
        double[] stage=new double[N+1];
        for(int i : stages)
            stage[i-1]++;

        int sum=0;
        int people=stages.length;
        for(int i=0;i<N;i++){
            sum+=(int)stage[i];
            stage[i]=stage[i]/(people-sum+stage[i])+(i+1);
            if(stage[i]==i+2) stage[i]=i+1+0.999999999;
            System.out.println(stage[i]);
        }

        int[] answer = new int[N];

        for(int i=0;i<N;i++){
            double max=-1;
            int nanflag=-1;

            for(int j=0;j<N;j++) {
                if(Double.isNaN(stage[j])){
                    nanflag=j;
                    break;
                }
                if (max%1 < stage[j] % 1&& stage[j]>0)
                    max = stage[j];
            }

            if(nanflag>=0){
                answer[i]=nanflag+1;
                System.out.println(answer[i]+"NAN");
                stage[nanflag]=0;
            }

            else if(max==-1){
                for(int j=i;j<N;j++)
                    for(int k=0;k<N;k++)
                        if(stage[k]>0) {
                            answer[j]=(int)stage[k]/1;
                            stage[k]=0;
                            break;
                        }
            }
            else{
                answer[i]=(int)max/1;
                System.out.println(answer[i]);
                stage[(int)max/1-1]=0;
            }

        }

        return answer;
    }
    public static void main(String args[]){
        kakao42889 ex=new kakao42889();
        int a[]= {2,1,2,4,2,4,3,3};
        System.out.println(Arrays.toString(ex.solution(5,a)));
    }
}
