package 백준.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14427_수열과쿼리15 {
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
                sb.append(segArr[1] + 1).append("\n");
            }
        }
        System.out.println(sb);
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