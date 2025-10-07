package 백준.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_7578_공장 {
    private static long[] segArr;
    private static int n;
    private static Map<Integer, Integer> mapA = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int machineId = Integer.parseInt(stA.nextToken());
            mapA.put(machineId, i);
        }

        segArr = new long[4 * n];
        long totalCrossings = 0;

        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int machineIdB = Integer.parseInt(stB.nextToken());
            int indexInA = mapA.get(machineIdB);

            totalCrossings += query(1, 0, n - 1, indexInA + 1, n - 1);
            update(1, 0, n - 1, indexInA);
        }

        System.out.println(totalCrossings);
    }

    private static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0; // 합이므로 0을 반환
        }
        if (left <= start && end <= right) {
            return segArr[node];
        }

        int mid = (start + end) / 2;
        long leftSum = query(node * 2, start, mid, left, right);
        long rightSum = query(node * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    private static void update(int node, int start, int end, int index) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            segArr[node] = 1;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index);
        update(node * 2 + 1, mid + 1, end, index);

        segArr[node] = segArr[node * 2] + segArr[node * 2 + 1];
    }
}