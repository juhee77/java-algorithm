package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1449_수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // -0.5 +0.5
        PriorityQueue<Integer> arr = new PriorityQueue<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int now = 0;
        int cnt = 0;
        while (!arr.isEmpty()) {

            while (!arr.isEmpty() && arr.peek() < now) {
                arr.poll();
            }

            if (!arr.isEmpty()) {
                now = arr.poll() + l;
                cnt++;
            }

        }
        System.out.println(cnt);


    }
}
