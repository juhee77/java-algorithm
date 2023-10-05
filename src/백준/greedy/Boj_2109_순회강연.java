package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2109_순회강연 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> lecture = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int maxDay = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            maxDay = Math.max(day, maxDay);

            lecture.add(new int[]{day, time});
        }

        PriorityQueue<int[]> ableLecture = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int money=0;

        for(int i=maxDay;0<i;i--) {
            while (!lecture.isEmpty() && lecture.peek()[0] == i) {
                //해당 요일에 가능한 강의가 있다면 모두 추가한다.
                ableLecture.add(lecture.poll());
            }

            if (!ableLecture.isEmpty()) {
                //해당 요일에 가능한 강의가 있다면 강의를 수락한다.
                money += ableLecture.poll()[1];
            }
        }
        System.out.println(money);
    }
}
