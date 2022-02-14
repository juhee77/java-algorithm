package 프로그래머스.level1;
import java.awt.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class 완주하지못한선수_해시테이블이용 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash = new HashMap<>();
        for(int i=0;i<completion.length;i++){
            if(hash.containsKey(completion[i])==false)
                hash.put(completion[i], 0);
            else
                hash.put(completion[i], hash.get(completion[i])+1);
        }


        for(int i=0;i<participant.length;i++){
            if(hash.containsKey(participant[i])==false){
                answer=answer.concat(participant[i]);
            }
            else{
                if(hash.get(participant[i])==0)
                    hash.remove(participant[i]);
                else
                    hash.put(participant[i], hash.get(participant[i])-1);
            }
        }

        return answer;
    }

    public static void main(String args[]){
        String[] s={"leo", "kiki", "eden"};
        String[] a={"eden", "kiki"};
        System.out.print(solution(s,a));
    }
}

