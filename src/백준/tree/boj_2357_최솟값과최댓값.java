package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2357_최솟값과최댓값 {
    private static final int[] num = new int[100001];
    private static final int[] maxTree = new int[400000];
    private static final int[] minTree = new int[400000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken()); //숫자 수
        for (int i = 0; i < cnt; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        maxTreeInit(0, cnt - 1, 1); //최댓값 트리 세팅
        minTreeInit(0, cnt - 1, 1); //최소값 트리 세팅

        int line = Integer.parseInt(st.nextToken());
        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int min = findMin(0, cnt - 1, 1, a, b);
            int max = findMax(0, cnt - 1, 1, a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static int findMax(int start, int end, int node, int left, int right) {
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return maxTree[node];
        int mid = (start + end) >> 1;
        return Math.max(findMax(start, mid, node * 2, left, right), findMax(mid + 1, end, node * 2 + 1, left, right));

    }

    private static int findMin(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 1_000_000_000;
        if (left <= start && end <= right) return minTree[node];
        int mid = (start + end) >> 1;
        return Math.min(findMin(start, mid, node * 2, left, right), findMin(mid + 1, end, node * 2 + 1, left, right));
    }

    private static int minTreeInit(int start, int end, int node) {
        if (start == end) return minTree[node] = num[start];
        int mid = (start + end) >> 1;
        return minTree[node] = Math.min(minTreeInit(start, mid, node * 2), minTreeInit(mid + 1, end, node * 2 + 1));
    }

    private static int maxTreeInit(int start, int end, int node) {
        if (start == end) return maxTree[node] = num[start];
        int mid = (start + end) >> 1;
        return maxTree[node] = Math.max(maxTreeInit(start, mid, node * 2), maxTreeInit(mid + 1, end, node * 2 + 1));

    }
}
