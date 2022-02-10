package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 모의고사_수정 {
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

        int max =Math.max(Math.max(answer[0],answer[1]),answer[2]);

        ArrayList<Integer> list = new ArrayList<Integer>();

        if(max==answer[0]) list .add(1);
        if(max==answer[1]) list .add(2);
        if(max==answer[2]) list .add(3);

        int[] ans = new int[list.size()];
        for(int i=0;i< list.size();i++){
            ans[i]=list.get(i);
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
        int b[]={5,4,4,2,1};
        int bns[]=solution(b);
        System.out.println();
        for(int i=0;i<bns.length;i++){
            System.out.print(bns[i]+"   ");
        }
    }
}
