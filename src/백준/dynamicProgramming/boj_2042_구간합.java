package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2042_구간합 {
    private static long[] arr;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자 수
        int M = Integer.parseInt(st.nextToken()); // 변경 수
        int K = Integer.parseInt(st.nextToken()); //구간 합수

        /* 5%에러 트리 범위를 넓게 설정 */
        arr = new long[1000001];
        tree = new long[4000000];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, N - 1, 1);
        while (M + K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                long diff = Long.parseLong(st.nextToken()) - arr[index];
                update(0, N - 1, 1, index, diff);
            } else {
                int sumStart = Integer.parseInt(st.nextToken()) - 1;
                int sumEnd = Integer.parseInt(st.nextToken()) - 1;
                sb.append(sum(0, N - 1, 1, sumStart, sumEnd)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) >> 1;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) >> 1;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end) return;
        tree[node] += diff;
        if (start == end) {
            arr[start] += diff;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }
}
