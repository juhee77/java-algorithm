package 프로그래머스.level1;

import java.util.Arrays;

public class kakao42889_Modi {
    public int[] solution(int N, int[] stages) {
        double[] stage=new double[N+1];
        for(int i : stages)
            stage[i-1]++;

        int sum=0;
        int people=stages.length;
        for(int i=0;i<N;i++){
            sum+=(int)stage[i];
            if(people-sum+stage[i]==0) stage[i]=i+1;
            else {
                stage[i] = stage[i] / (people - sum + stage[i]) + (i + 1);
                if (stage[i] == i + 2) stage[i] = i + 1 + 0.999999999;
            }
            //if(Double.isNaN(stage[i])||Double.isInfinite(stage[i]) ) stage[i]=i+1;
        }

        int[] answer = new int[N];

        for(int i=0;i<N;i++){
            double max=-1;

            for(int j=0;j<N;j++) {
                if (max%1 < stage[j] % 1&& stage[j]>0)
                    max = stage[j];
            }

            if(max==-1){
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
                stage[(int)max/1-1]=-1;
            }

        }

        return answer;
    }
    // 제츨
    public int[] solution2(int N, int[] stages) {
        double[] stage=new double[N+1];
        for(int i : stages)
            stage[i-1]++;

        int sum=0;
        int people=stages.length;
        for(int i=0;i<N;i++){
            sum+=(int)stage[i];
            if(people-sum+stage[i]==0) stage[i]=0.0;
            else {
                stage[i] = stage[i] / (people - sum + stage[i]) ;
            }
        }

        int[] answer = new int[N];

        for(int i=0;i<N;i++){
            double max=0;
            int maxI=-1;
            for(int j=0;j<N;j++) {
                if (max< stage[j] && stage[j]>0){
                    max = stage[j];
                    maxI=j;
                }
            }

            if(max==0){
                for(int j=i;j<N;j++)
                    for(int k=0;k<N;k++)
                        if(stage[k]>=0) {
                            answer[j]=(int)k+1;
                            stage[k]=-1;
                            break;
                        }
            }
            else{
                answer[i]=maxI+1;
                stage[maxI]=-1;
            }

        }

        return answer;
    }

    public static void main(String args[]){
        kakao42889_Modi ex=new kakao42889_Modi();
        int a[]= {4,4,4,4,4};
        System.out.println(Arrays.toString(ex.solution(3,a)));
    }
}
