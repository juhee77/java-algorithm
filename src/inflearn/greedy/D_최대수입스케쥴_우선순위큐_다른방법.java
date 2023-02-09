package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class D_최대수입스케쥴_우선순위큐_다른방법 {
    private static class Lecture implements Comparable<Lecture> {
        public int money;
        public int limitDay;

        Lecture(int money, int time) {
            this.money = money;
            this.limitDay = time;
        }

        @Override
        public int compareTo(Lecture ob) {
            return ob.limitDay - this.limitDay;
        }
    }

    static int n, max = Integer.MIN_VALUE;

    public static int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).limitDay < i) break; //3일차면 3일차 수업에 해당하는 내용만 돌고 브레이크
                // 가능한 날짜가 많은 수업부터 넣는다. [[이후에 1일차에가도 가능한 수업들이므로]
                queue.offer(arr.get(j).money);
            }
            //넣은 수업중 하나를 뺀다.[3일차에 할 수업]
            if (!queue.isEmpty()) answer += queue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int limitDay = sc.nextInt();
            arr.add(new Lecture(money, limitDay));
            if (limitDay > max) max = limitDay;
        }
        System.out.println(solution(arr));
    }
}