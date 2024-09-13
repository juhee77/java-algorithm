package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Boj_1337_올바른배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < n; j++) {
            int now = Integer.parseInt(br.readLine());
            set.add(now);
            arr.add(now);
        }

        int minHold = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Integer now = arr.get(i);
            int hold = 0;
            for (int j = now; j < now + 5; j++) {
                if (!set.contains(j)) {
                    hold++;
                }
            }
            minHold = Math.min(minHold, hold);
            if (minHold == 0) break;
        }
        System.out.println(minHold);
    }
}
