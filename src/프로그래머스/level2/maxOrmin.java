package 프로그래머스.level2;
//https://programmers.co.kr/learn/courses/30/lessons/12939 -- 최댓값과 최솟값 <0405>
import java.util.Arrays;

public class maxOrmin {
    public String solution(String s) {
        Integer[] num = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[] :: new);
        Arrays.sort(num);

        return num[0]+" "+num[num.length-1];
    }
    public static void main(String args[]){
        System.out.println(new maxOrmin().solution("1 2 3 4"));
    }
}
