package 백준.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1374_강의실_pq {
    private static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture other) {
            return start - other.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lectures = new PriorityQueue<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int minClassCnt = 0;
        PriorityQueue<Integer> currentLectures = new PriorityQueue<>(); //끝나는 시간만 넣는다.
        while (!lectures.isEmpty()) {
            Lecture lecture = lectures.poll();

            //해당 수업 시간 전에 끝난 수업이 있으면 뺀다.
            while (!currentLectures.isEmpty() && currentLectures.peek() <= lecture.start) {
                currentLectures.poll();
            }

            //시작시간이 같은 수업이 있다면 넣는다.
            currentLectures.add(lecture.end);
            while (!lectures.isEmpty() && lectures.peek().start == lecture.start) {
                currentLectures.add(lectures.poll().end);
            }

            //현재 큐의 사이즈가 현재 시간에 필요한 회의실의 수 이다.
            minClassCnt = Math.max(currentLectures.size(), minClassCnt);
        }
        System.out.println(minClassCnt);
    }
}
