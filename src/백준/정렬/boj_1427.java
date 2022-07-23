package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class boj_1427 {
    public long solution(long n) {
        List a = String.valueOf(n).chars().map(ch -> ch - '0').boxed().collect(Collectors.toList());
        Collections.sort(a,Collections.reverseOrder());
        String answer = a.toString().replaceAll("\\[|\\]","").replaceAll(",| ","");
        //System.out.println(a.toString().replaceAll("\\[|\\]","").replaceAll(",| ",""));
        return Long.parseLong(answer);
    }
    public static void main(String[] args) throws IOException {
        boj_1427 a = new boj_1427();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n=Long.parseLong(br.readLine());
        System.out.println(a.solution(n));

    }
}
