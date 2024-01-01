package 백준.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
가장 적게 주유소를 방문하는 방법임
여기서는 우선순위 큐를 사용함
방문이 적게 되었는데 기름이 많을수록 좋음
만약 방문하려고 하는 point가 지금 가지고 있는 기름으로 도달 불가능 하면 큐에 넣지 않는다.
bank는 정렬해두고 제일 작은 점 부터 방문
bank를 앞에서 부터 방문하는데 모두 방문해도 안되면 -1
만약 어떠한 뱅크도 방문하지 못하는 상황인데 goal에 도달 하지 못하면 -1
 */

public class boj_1826_연료채우기 {
    private static class Nowoil implements Comparable<Nowoil> {
        int nowHavingOil;
        int visitedBank;
        int shownBank;

        public Nowoil(int nowHavingOil, int visitedBank, int shownBank) {
            this.nowHavingOil = nowHavingOil;
            this.visitedBank = visitedBank;
            this.shownBank = shownBank;
        }

        @Override
        public int compareTo(Nowoil o) {
            if (visitedBank == o.visitedBank) return o.nowHavingOil - nowHavingOil;
            return visitedBank - o.visitedBank;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        list.sort(Comparator.comparingInt(o -> o[0]));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int remainDistance = Integer.parseInt(st.nextToken());
        int havingOil = Integer.parseInt(st.nextToken());

        System.out.println(checkintMin(havingOil, remainDistance, list));
    }



    private static int checkintMin(int havingOil, int remain, ArrayList<int[]> list) {
        PriorityQueue<Nowoil> oilList = new PriorityQueue<>();
        oilList.add(new Nowoil(havingOil, 0, 0));
        while (!oilList.isEmpty()) {
            Nowoil now = oilList.poll();

            if (now.nowHavingOil >= remain) return now.visitedBank;

            if (now.shownBank == list.size()) continue;
            //방문 가능한 경우
            if (list.get(now.shownBank)[0] <= remain) {
                //방문 안함
                oilList.add(new Nowoil(now.nowHavingOil, now.visitedBank, now.shownBank + 1));

                //방문 함
                int nowHavingOil = now.nowHavingOil + list.get(now.shownBank)[1];
                oilList.add(new Nowoil(nowHavingOil, now.visitedBank + 1, now.shownBank + 1));
            }

            //방문하지 못하는 경우
            if (list.get(now.shownBank)[0] > remain) {
                continue;
            }

        }
        return -1;
    }
}
/*
4
1 2
3 4
7 10
15 2
20 12
 */