package 프로그래머스.level1;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 정수내림차순배치 {
    public long solution(long n) {
        List a = String.valueOf(n).chars().map(ch -> ch - '0').boxed().collect(Collectors.toList());
        Collections.sort(a, Collections.reverseOrder());
        String answer = a.toString().replaceAll("\\[|\\]", "").replaceAll(",| ", "");
        //System.out.println(a.toString().replaceAll("\\[|\\]","").replaceAll(",| ",""));
        return Long.parseLong(answer);
    }

    public static void main(String args[]) {
        정수내림차순배치 a = new 정수내림차순배치();
        System.out.println(a.solution(118372));
    }
}
