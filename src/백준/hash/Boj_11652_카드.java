package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_11652_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Long, Integer> hash = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Long now = Long.parseLong(br.readLine());
            hash.put(now, hash.getOrDefault(now, 0) + 1);
        }

        Long minIndex = Long.MAX_VALUE;
        int maxCnt = 0;
        for (Map.Entry<Long, Integer> entry : hash.entrySet()) {
            Long key = entry.getKey();
            int value = entry.getValue();
            if (maxCnt < value) {
                minIndex = key;
                maxCnt = value;
            } else if (maxCnt == value) {
                minIndex = Math.min(minIndex, key);
            }
        }

        System.out.println(minIndex);
    }
}
