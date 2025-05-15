package 프로그래머스.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_12972_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            q.add(work);
        }

        while (n-- > 0 && !q.isEmpty()) {
            int temp = q.poll() - 1;
            if (temp > 0)
                q.add(temp);
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            answer += (long) temp * temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_12972_야근지수 programmers12972_야근지수 = new Programmers_12972_야근지수();
        System.out.println(programmers12972_야근지수.solution(4, new int[]{4,3,3}));
    }
}
