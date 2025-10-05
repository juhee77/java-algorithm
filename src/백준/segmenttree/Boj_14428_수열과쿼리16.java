package 백준.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14428_수열과쿼리16 {
    private static int[] segArr;
    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int Q = Integer.parseInt(br.readLine());

        segArr = new int[4 * n];
        build(1, 0, n - 1);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());
                update(index, value);
            } else if (a == 2) {
                int startIndex = Integer.parseInt(st.nextToken()) - 1;
                int endIndex = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(startIndex, endIndex) + 1).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int query(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    private static int query(int node, int start, int end, int left, int right) {
        // [case 1] 쿼리 구간이 현재 노드의 구간과 전혀 겹치지 않는 경우
        if (right < start || end < left) {
            return Integer.MAX_VALUE; // 최솟값 연산에 영향을 주지 않는 큰 값 반환
        }

        // [case 2] 쿼리 구간이 현재 노드의 구간을 완전히 포함하는 경우
        if (left <= start && end <= right) {
            return segArr[node];
        }

        // [case 3] 쿼리 구간이 현재 노드의 구간과 일부만 겹치는 경우
        int mid = (start + end) / 2;
        int leftMin = query(node * 2, start, mid, left, right);
        int rightMin = query(node * 2 + 1, mid + 1, end, left, right);
        if (leftMin == Integer.MAX_VALUE || rightMin == Integer.MAX_VALUE) return Math.min(leftMin, rightMin);
        return arr[leftMin] <= arr[rightMin] ? leftMin : rightMin;
    }

    public static void update(int index, int value) {
        arr[index] = value; // 원본 배열의 값을 갱신
        update(1, 0, n - 1, index);
    }

    private static int build(int node, int start, int end) {
        if (start == end) {
            return segArr[node] = start;
        }

        int mid = (start + end) / 2;
        int leftMinIndex = build(node * 2, start, mid);
        int rightMinIndex = build(node * 2 + 1, mid + 1, end);

        if (arr[leftMinIndex] <= arr[rightMinIndex]) {
            return segArr[node] = leftMinIndex;
        } else {
            return segArr[node] = rightMinIndex;
        }
    }

    private static int update(int node, int start, int end, int index) {
        if (index < start || index > end || start == end) {
            return segArr[node];
        }

        int mid = (start + end) / 2;
        int leftMinIndex = update(node * 2, start, mid, index);
        int rightMinIndex = update(node * 2 + 1, mid + 1, end, index);

        if (arr[leftMinIndex] <= arr[rightMinIndex]) {
            return segArr[node] = leftMinIndex;
        } else {
            return segArr[node] = rightMinIndex;
        }
    }
}