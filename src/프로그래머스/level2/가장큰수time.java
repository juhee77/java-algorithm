package 프로그래머스.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수time {
    public static String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        String answer="";

        /*프로그래머스 코드*/
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        answer=String.join("",nums);
        if(answer.substring(0,1).equals("0")) return "0";
        return answer;

    }


    public static void main(String args[]){
        int[] a={3, 30, 34, 5, 9};
        System.out.println(solution(a));
        int[] b={2,20,200};
        System.out.println(solution(b));
        int[] c={6, 10, 2};
        System.out.println(solution(c));
    }
}
