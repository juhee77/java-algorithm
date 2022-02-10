package 프로그래머스.level1;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {
    public static int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int[] answer_first={1,2,3,4,5};
        int[] answer_second ={2,1,2,3,2,4,2,5};
        int[] answer_third={3,3,1,1,2,2,4,4,5,5};
        ArrayList sol=new ArrayList();
        for(int i=0;i<answers.length;i++){
            if(answers[i] == answer_first[i%5])
                answer[0]++;
            if(answers[i]==answer_second[i%8])
                answer[1]++;
            if(answers[i]==answer_third[i%10])
                answer[2]++;
        }
        //int[] copyans = answer; 자바 배열 그대로 복사하면 주소값이 복사되어 같이 이동함
        //Arrays.sort(copyans,Collections.reverseOrder()); 역정렬 방법[10,9,8..] 문제는 int인 경우는 안돼서 integet 로 바꿔서 해야함

        Integer copyans[] = new Integer[answer.length];
        for(int i=0;i<answer.length;i++){
            copyans[i]=answer[i];
        }
        Arrays.sort(copyans,Collections.reverseOrder());

        /* */
        for(int i=0;i<copyans.length;i++){
            System.out.println(copyans[i]+": "+answer[i]);
        }
        /* */

        int[] ans;

        //max확인
        if(copyans[0]==copyans[2]){
            ans=new int[] {1,2,3};
        }
        else if(copyans[0]==copyans[1]){
            if(copyans[0]==answer[0]&&copyans[0]==answer[1]) ans=new int[] {1,2};
            else if(copyans[0]==answer[0]&&copyans[0]==answer[2]) ans=new int[] {1,3};
            else ans=new int[] {2,3};
        }
        else{
            if(copyans[0]==answer[0])ans=new int[] {1};
            else if(copyans[0]==answer[1])ans=new int[] {2};
            else ans=new int[] {3};
        }
        return ans;
    }
    public static void main(String args[]){
        int a[]={3,3,2,1,5};
        int ans[]=solution(a);
        System.out.println();
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+"   ");
        }
        int b[]={1,2,1,1,4};
        int bns[]=solution(b);
        System.out.println();
        for(int i=0;i<bns.length;i++){
            System.out.print(bns[i]+"   ");
        }
    }
}
