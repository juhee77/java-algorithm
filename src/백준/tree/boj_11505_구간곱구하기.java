package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11505_구간곱구하기 {
    private static int[] arr = new int[1000001];
    private static long[] tree = new long[4000001];
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, n - 1, 1);

        while (k + m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) { //b->c
                int index = Integer.parseInt(st.nextToken()) - 1;
                long diff = Long.parseLong(st.nextToken());
                update(0, n - 1, 1,index ,diff);

            } else { //b~c합
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                sb.append(sum(0, n - 1, 1, start, end)).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static long update(int start, int end, int node, int index, long val) {

        if (index < start || index > end)  return tree[node];

        if (start == end) return tree[node] = val;

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, index, val)
                * update(mid + 1, end, node * 2 + 1, index, val)) % MOD;
    }

    /* 틀린 버전(곱셈은 밑에서 부터 올라오도록)
        private static void update(int left, int right, int node, int index, double diff) {
        if (index < left|| index > right) return;
        tree[node] = (long) ((tree[node]*diff)%MOD);
        if(left==right) return;

        int mid = (left + right) >> 1;
        update(left, mid, node * 2,index, diff);
        update(mid + 1, right, node * 2 + 1,index,  diff);
    }
     */

    private static long sum(int start, int end, int index, int left, int right) {
        if (end < left || right < start) return 1;
        if (left <= start && end <= right) return tree[index];
        int mid = (start + end) >> 1;
        return (sum(start, mid, index * 2, left, right) * sum(mid + 1, end, index * 2 + 1, left, right)) % MOD;
    }

    private static long init(int left, int right, int index) {
        if (left == right) return tree[index] = arr[right];
        int mid = (left + right) >> 1;
        return tree[index] = (init(left, mid, index * 2) * init(mid + 1, right, index * 2 + 1)) % MOD;
    }
}
