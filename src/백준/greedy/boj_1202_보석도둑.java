package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1202_보석도둑 {
    private static class dia {
        int weight, money;

        public dia(int weight, int money) {
            this.weight = weight;
            this.money = money;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] bag = new int[k];
        ArrayList<dia> dias = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dias.add(new dia(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dias.sort(Comparator.comparingInt(o -> o.weight));
        for (int i = 0; i < k; i++) bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n && dias.get(j).weight <= bag[i])
                pq.offer(dias.get(j++).money);

            if (!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);
    }
}
