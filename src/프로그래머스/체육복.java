package 프로그래머스;
import java.util.*;
public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int index=0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0;i<lost.length;i++){
            for(int j=index;j<reserve.length;j++){
                if(lost[i]-1 ==reserve[j]||lost[i]==reserve[j]||lost[i]+1 == reserve[j] ) {
                    answer++;
                    index=j+1;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String args[]){
        int a[] = {2,4};
        int b[]={1,3,5};
        System.out.println(solution(5,a,b));
        int c[] = {3};
        int d[]={1};
        System.out.println(solution(3,c,d));
    }
}
