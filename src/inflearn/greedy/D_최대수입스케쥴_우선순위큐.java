package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_최대수입스케쥴_우선순위큐 {
    private static class Seminar implements Comparable<Seminar> {
        int money, limitDay;

        public Seminar(int money, int limitDay) {
            this.money = money;
            this.limitDay = limitDay;
        }

        @Override
        public int compareTo(Seminar other) {
            return this.limitDay - other.limitDay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int line = Integer.parseInt(br.readLine());
        List<Seminar> seminars = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            seminars.add(new Seminar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(seminars);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Seminar seminar : seminars) {
            if (queue.size() < seminar.limitDay) {
                //큐사이즈[[현재 강의예정 강의]], 현재강의를 limitDay 안에 해주길 바란다.
                //근데 제안한 날짜보다 수업이 덜 있음-> 이수업을 하는게 이득 (0이상이기만 하다면)
                queue.add(seminar.money);
            } else {
                // 현재 예정 수업중 가장 수입이 작은 수업보다 지금 진행하는 수입의 가격이 크다면
                // 가장 작은 수업빼고 해당 수업을 예정한다.
                if (queue.peek() < seminar.money) {
                    queue.poll();
                    queue.add(seminar.money);
                }
            }
        }

        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        System.out.println(sum);
    }
}
