package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_15903_카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //가장 작게 만들 수 있는 x,y 모두에 최솟값일 수록 좋다.
        PriorityQueue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //카드 수
        int m = Integer.parseInt(st.nextToken());//카드 합체를 몇번 하는지

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0) {
            long min1 = cards.poll();
            long min2 = cards.poll();
            cards.add(min1 + min2);
            cards.add(min1 + min2);
        }

        long sum = 0;
        while (!cards.isEmpty()) {
            sum += cards.poll();
        }
        System.out.println(sum);
    }
}
