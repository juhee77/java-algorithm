package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int classNums = Integer.parseInt(br.readLine());
        List<ClassTime> allClass = new ArrayList<>();
        PriorityQueue<Integer> room = new PriorityQueue<>();
        while (classNums-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            allClass.add(new ClassTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        allClass.sort(Comparator.comparingInt(o -> o.start));

        room.add(0);
        for (ClassTime nowClass : allClass) {
            if (checkingAvailableClass(room, nowClass)) {
                //기존의 클래스를 제거한다.
                room.poll();
            }
            room.add(nowClass.end);
        }
        System.out.println(room.size());
    }

    private static boolean checkingAvailableClass(PriorityQueue<Integer> room, ClassTime nowClass) {
        //앞에 가장 빠르게 끝난 수업의 시간이 있는데 그것보다 시작지간이 빠르다면 다른 클래스를 추가해야한다
        return room.peek() <= nowClass.start;
    }

    private static class ClassTime {
        int start, end;

        public ClassTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
