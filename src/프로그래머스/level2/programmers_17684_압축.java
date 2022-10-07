package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class programmers_17684_압축 {
    public int[] solution(String msg) {

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String,Integer> hash = new HashMap<>();
        int now=1;
        for(char c= 'A';c<='Z';c++){
            hash.put(c+"", now++);
        }
        int i=0;
        int j=0;
        while(i<msg.length()){
            j=i;
            while (j < msg.length()){
                if(!hash.containsKey(msg.substring(i,j+1)))break;
                j++;
            }
            //System.out.println(i+" "+j);
            arr.add(hash.get(msg.substring(i,j)));

            if(j==msg.length()) break;
            hash.put(msg.substring(i,j+1),now++);
            i=j;
        }

        int[] answer = new int[arr.size()];
        for(i=0;i<arr.size();i++)answer[i]=arr.get(i);
        return answer;
    }
    public static void main(String args[]){
        System.out.println(Arrays.toString(new programmers_17684_압축().solution("ABABABABABABABAB")));
        System.out.println(Arrays.toString(new programmers_17684_압축().solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(new programmers_17684_압축().solution("KAKAO")));
    }
}
