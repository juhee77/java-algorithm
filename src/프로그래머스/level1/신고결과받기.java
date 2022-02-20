package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/92334
import java.util.Arrays;
import java.util.HashMap;

public class 신고결과받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {

        int people=id_list.length;
        int[] answer = new int[people];
        int[][] cnt=new int[people][people];
        int[] totalCnt=new int[people];

        HashMap<String,Integer> hash = new HashMap<>();
        for(int i=0;i<people;i++) hash.put(id_list[i],i);

        for(int i=0;i<report.length;i++){
            String[] temp=report[i].split(" ");
            int key1=hash.get(temp[0]),key2=hash.get(temp[1]);
            if(cnt[key1][key2]<1) { //한번 이상 신고하지 못함
                cnt[key1][key2]++;
                totalCnt[key2]++;
            }
        }

        for(int i=0;i<report.length;i++){
            String[] temp=report[i].split(" ");
            int key1=hash.get(temp[0]),key2=hash.get(temp[1]);
            if(totalCnt[key2]>=k&&cnt[key1][key2]>=1){
                answer[key1]++;
                cnt[key1][key2]--;
            }
        }
        return answer;
    }
    public static void main(String args[]){
        String[] name1={"muzi", "frodo", "apeach", "neo"};
        String[] report1={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int[] ans= solution(name1,report1,2);
        System.out.println(Arrays.toString(ans));

        String[] name2={"con", "ryan"};
        String[] report2={"ryan con", "ryan con", "ryan con", "ryan con"};
        int[] ans2= solution(name2,report2,3);
        System.out.println(Arrays.toString(ans2));

    }
}
