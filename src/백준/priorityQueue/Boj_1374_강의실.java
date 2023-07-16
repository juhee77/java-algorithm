package 백준.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1374_강의실 {
    private static class Lecture implements Comparable<Lecture> {
        int time;
        boolean isStart;

        public Lecture(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Lecture other) {
            if (this.time == other.time) {
                if(!this.isStart) return -1; //끝 -> 시작순으로 진행 하도록 하기 위해서
                return 1;
            }
            return time - other.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> all = new PriorityQueue<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            all.add(new Lecture(Integer.parseInt(st.nextToken()), true)); //시작
            all.add(new Lecture(Integer.parseInt(st.nextToken()), false)); //끝
        }

        int classCnt = 0;
        int minClassCnt = 0;
        while (!all.isEmpty()) {
            Lecture lecture = all.poll();
            if (lecture.isStart) {
                classCnt++; //시작 수업이다 ( 강의실이 하나 더 필요하다)
            } else {
                classCnt--; //끝나는 수업이다 (강의실 하나 이제 안 필요하다)
            }
            minClassCnt = Math.max(classCnt, minClassCnt);
        }
        System.out.println(minClassCnt);
    }
}
