package 프로그래머스.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class sortStringtoList {
    public String solution(String s) {
        String[] answer= s.split("");
        Arrays.sort(answer, Comparator.reverseOrder());
        return Arrays.toString(answer).replaceAll("\\[|\\]","").replaceAll(",","").replaceAll(" ","");
    //return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
    public static void main(String args[]){
        sortStringtoList ex=new sortStringtoList();
        System.out.println(ex.solution("Zbcdefg"));
    }
}
