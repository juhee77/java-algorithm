package 백준.Que;

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

public class boj_1826_연료채우기2 {
    private static class fuel {
        int dist, quantity;

        public fuel(int dist, int quantity) {
            this.dist = dist;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<fuel> oilbankList = new PriorityQueue<>(Comparator.comparingInt(f -> f.dist));
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int quan = Integer.parseInt(st.nextToken());
            oilbankList.add(new fuel(dist, quan));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int remainDistance = Integer.parseInt(st.nextToken());
        int havingOil = Integer.parseInt(st.nextToken());

        System.out.println(checkintMin(havingOil, remainDistance, oilbankList));
    }


    private static int checkintMin(int havingOil, int remain, PriorityQueue<fuel> bankList) {
        PriorityQueue<Integer> oilList = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        int ans = 0;

        while (remain > havingOil) {
            if (oilList.isEmpty() && bankList.isEmpty()) {
                return -1;
            }
            if (oilList.isEmpty() && bankList.peek().dist > havingOil) {
                return -1;
            }
            while (!bankList.isEmpty() && bankList.peek().dist <= havingOil) {
                oilList.add(bankList.poll().quantity);
            }

            if (!oilList.isEmpty()) {
                havingOil += oilList.poll();
                ans++;
            }

        }
        return ans;
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