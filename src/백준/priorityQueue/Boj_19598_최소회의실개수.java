package 백준.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_19598_최소회의실개수 {

    private static class Meeting implements Comparable<Meeting> {
        int time;
        boolean isStart;

        public Meeting(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Meeting o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> meetings = new PriorityQueue<>();
        //최소 회의실 개수
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), true));
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), false));
        }

        int meetingRoomCnt = 0;
        int maxMeetingRoom = 0;
        while (!meetings.isEmpty()) {
            Meeting me = meetings.poll();

            if (me.isStart) {
                meetingRoomCnt++;
                maxMeetingRoom = Math.max(maxMeetingRoom, meetingRoomCnt);
            } else {
                meetingRoomCnt--;
            }
        }
        System.out.println(maxMeetingRoom);

    }
}
