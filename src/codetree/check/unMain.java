package codetree.check;

import java.io.*;
import java.util.*;

public class unMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 배열 크기
        int k = Integer.parseInt(br.readLine()); // 서로 다른 원소 개수 제한
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 왼쪽에서 최대 부분 수열 `B` 찾기 (dp[i] = 0~i까지의 최적 길이)
        int[] dp = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, maxB = 0;

        for (int end = 0; end < n; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() >= k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) map.remove(arr[start]);
                start++;
            }

            dp[end] = Math.max((end > 0 ? dp[end - 1] : 0), end - start + 1);
            maxB = Math.max(maxB, dp[end]);
        }

        // 2. 오른쪽에서 최대 부분 수열 `C` 찾기
        map.clear();
        int maxBC = 0, maxC = 0;
        start = n - 1;

        for (int end = n - 1; end >= 0; end--) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() >= k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) map.remove(arr[start]);
                start--;
            }

            maxC = start - end + 1;
            int maxBLeft = (end > 0) ? dp[end - 1] : 0;
            maxBC = Math.max(maxBC, maxBLeft + maxC);
        }

        System.out.println(maxBC);
    }
}
