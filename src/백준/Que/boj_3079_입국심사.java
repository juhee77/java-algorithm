package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_3079_입국심사 {
    private static class people implements Comparable<people> {
        int nowTime;
        int waitingTime;

        public people(int nowTime, int waitingTime) {
            this.nowTime = nowTime;
            this.waitingTime = waitingTime;
        }

        @Override
        public int compareTo(people o) {
            if (this.nowTime == o.nowTime) {
                return waitingTime - o.waitingTime;
            }
            return nowTime - o.nowTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<people> waitingList = new PriorityQueue<>();

        while (N-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            waitingList.add(new people(temp, temp));
        }

        int finishPeople = 0;
        while (finishPeople < M-1) {
            people nowPeople = waitingList.poll();
            waitingList.add(new people(nowPeople.nowTime + nowPeople.waitingTime, nowPeople.waitingTime));
            finishPeople++;
        }
        System.out.println(waitingList.peek().nowTime);
    }
}
