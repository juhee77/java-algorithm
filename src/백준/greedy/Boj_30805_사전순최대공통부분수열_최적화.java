package 백준.greedy;

import java.io.*;
import java.util.*;

public class Boj_30805_사전순최대공통부분수열_최적화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> {
            if (v1[0] == v2[0]) return v1[1] - v2[1]; // 값 같으면 인덱스 오름차순
            return v2[0] - v1[0]; // 값 내림차순
        });

        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.add(new int[]{num, i});
        }

        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Map<Integer, TreeSet<Integer>> bMap = new HashMap<>();
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());
            bMap.computeIfAbsent(num, k -> new TreeSet<>()).add(i);
        }

        int prevAIdx = -1;
        int prevBIdx = -1;
        List<Integer> ans = new ArrayList<>();

        //우선순위에 의한 큰 값만 계산하는 로직
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int num = curr[0], idx = curr[1];

            if (idx < prevAIdx || !bMap.containsKey(num)) continue;

            TreeSet<Integer> bSet = bMap.get(num);
            //이전에 등장했던 위치보다 무조건 큰곳에 위치하는것을 찾는다.
            Integer bIdx = bSet.higher(prevBIdx);
            if (bIdx == null) continue;

            prevAIdx = idx;
            prevBIdx = bIdx;
            ans.add(num);
        }

        System.out.println(ans.size());
        if (!ans.isEmpty()) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
