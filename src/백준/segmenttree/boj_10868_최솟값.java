package 백준.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10868_최솟값 {
    private static long[] arr;
    private static long[] segArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr = new long[a];
        segArr = new long[4 * a + 1];

        for (int i = 0; i < a; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        initMinSeg(0, a - 1, 1);
        for (int j = 0; j < b; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(findMin(0, a - 1, 1, x - 1, y - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static long findMin(int start, int end, int index, int left, int right) {
        if (end < left || right < start) return 1_000_000_000;
        if (left <= start && end <= right) return segArr[index];
        int mid = (start + end) >> 1;
        return Math.min(findMin(start, mid, index * 2, left, right), findMin(mid + 1, end, index * 2 + 1, left, right));
    }

    private static long initMinSeg(int start, int end, int idx) {
        if (start == end) return segArr[idx] = arr[start];
        int mid = (start + end) >> 1;
        return segArr[idx] = Math.min(initMinSeg(start, mid, idx * 2), initMinSeg(mid + 1, end, idx * 2 + 1));
    }
}
