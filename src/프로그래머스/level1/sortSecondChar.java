package 프로그래머스.level1;
//https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;
import java.util.stream.Collectors;

public class sortSecondChar {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        List<String> answer = Arrays.asList(strings).stream().map(s -> s.substring(n,n+1)).collect(Collectors.toList());
        Collections.sort(answer);

        //String ans[]=new String[strings.length];
        for(int i=0;i<strings.length;i++){
            int index=answer.indexOf(strings[i].substring(n,n+1));
            //ans[index]=strings[i];
            answer.set(index,strings[i]);
        }
        return answer.toArray(new String[answer.size()]) ;
    }

    public static void main(String args[]){
        sortSecondChar ex=new sortSecondChar();
        String[] a={"sun", "bed", "car"};

        System.out.println(Arrays.toString(ex.solution(a,1)));
    }
}
