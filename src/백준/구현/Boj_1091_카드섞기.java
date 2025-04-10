package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_1091_카드섞기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] goal = new int[n];
        int[] serve = new int[n];
        int[] now = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            goal[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            serve[i] = Integer.parseInt(st.nextToken());
            now[i] = i;
        }

        HashSet<String> set = new HashSet<>();
        int turn = 0;
        while (true) {
            boolean success = true;
            for (int i = 0; i < n; i++) {
                if (goal[now[i]] != i % 3) {
                    success = false;
                    break;
                }
            }

            if (success) {
                System.out.println(turn);
                return;
            }

            String beforeString = Arrays.toString(now);
            if (set.contains(beforeString)) {
                turn = -1;
                break;
            }

            set.add(beforeString);

            int[] swap = new int[n];
            for (int i = 0; i < n; i++) {
                //i번쨰 위치에 있던 카드는 S[iq]로 이동
                swap[serve[i]] = now[i];
            }
            now = swap;
            turn++;
        }
        System.out.println(turn);
    }

}
