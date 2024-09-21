package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_15810_풍선공장 {
    /**
     *
     *
     * 음수일 경우 : 두 원소의 위치를 교환 안함
     *
     * 양수일 경우 : 두 원소의 위치를 교환 함
     *
     *
     */
    private static class test implements Comparable<test>{
        int start;


        @Override
        public int compareTo(test o) {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int peCnt = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //시간. 걸리는 시간
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return 0;
            }
        });

        for (int i = 0; i < peCnt; i++) {
            int time = Integer.parseInt(st.nextToken());
            pq.add(new long[]{time, time});
        }

        long time = 0;
        while (0 < goal) {
            long[] poll = pq.poll();
            time = poll[0];
            goal--;
            pq.add(new long[]{time + poll[1], poll[1]});
        }

        System.out.println(time);
    }
}
