package 프로그래머스;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42862/solution_groups?language=java
public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int index=0;

        for(int i=0;i<lost.length;i++){
            for (int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    reserve[j]=-1;
                    lost[i]=-1;
                    break;
                }
            }
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);
        //복잡도 부분에서 안좋을듯
        //그냥 사람명수만큼 배열을 만들어서 lost-1, reserve +1로 해서 사람끼리 비교하는게 복작도가 더 좋을것 같다

        for(int i=0;i<lost.length;i++){
            for(int j=index;j<reserve.length;j++){
                if(lost[i]-1 ==reserve[j]||lost[i]+1 == reserve[j] ) {
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
