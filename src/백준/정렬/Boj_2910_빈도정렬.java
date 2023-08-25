package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2910_빈도정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());

        LinkedHashMap<Integer, Integer> hash = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        while (numCnt-- > 0) {
            int now = Integer.parseInt(st.nextToken());
            hash.put(now, hash.getOrDefault(now, 0) + 1);
        }

        List<int[]> rankNum = new ArrayList<>();
        for (Integer key : hash.keySet()) {
            rankNum.add(new int[]{key, hash.get(key)});
        }
        rankNum.sort((o1, o2) -> o2[1] - o1[1]);

        for (int[] ints : rankNum) {
            for (int i = 0; i < ints[1]; i++) {
                sb.append(ints[0] + " ");
            }
        }

        System.out.println(sb);
    }
}
