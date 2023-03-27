package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class boj_1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(LinkedList::new));

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());

            Deque<Integer> deque1 = new LinkedList<>(deque);
            Deque<Integer> deque2 = new LinkedList<>(deque);
            while (true) {
                if (deque1.peek() == now) {
                    deque1.poll();
                    deque = new LinkedList<>(deque1);
                    break;
                } else {
                    deque1.addLast(deque1.poll());
                }

                if (deque2.peek() == now) {
                    deque2.poll();
                    deque = new LinkedList<>(deque2);
                    break;
                } else {
                    deque2.addFirst(deque2.pollLast());
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
