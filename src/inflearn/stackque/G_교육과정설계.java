package inflearn.stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G_교육과정설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String recommend = br.readLine();
        String plan = br.readLine();

        System.out.println(solution(recommend.toCharArray(),plan.toCharArray()));
        System.out.println(solution2(recommend,plan));
    }

    private static String solution(char[] recommend, char[] plan) {
        Queue<Character> re = new LinkedList<>();

        for (char c : recommend) {
            re.add(c);
        }

        for (char c : plan) {
            if(re.isEmpty())break;
            if(c==re.peek()) re.poll();
        }

        if(re.isEmpty()) return "YES";
        else return "NO";
    }

    public static String solution2(String need, String plan){
        String answer="YES";
        Queue<Character> Q=new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()){
            //만약 들어있다면 순서대로 들어있어야 한다.
            if(Q.contains(x)){
                if(x!=Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";
        return answer;
    }
}
