package 백준.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2243_사탕상자 {
    private static final int MAX = 1_000_000;
    private static int[] seg = new int[(MAX+1)*4+1];

    //1이 가장 맛있는 사탕..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                //n 번째 순위의 것을 뺀다
                int k = Integer.parseInt(st.nextToken());
                sb.append(find(0, MAX, 1, k)).append("\n");
            } else {
                //a의 상탕 맛을 n개 만큼 넣거나 뺀다.
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                update(0, MAX, 1, a, b);
            }
        }
        System.out.println(sb);
    }

    private static int find(int start, int end, int index, int findRank) {
        seg[index]--;
        if (start == end) { //찾음
            return start;
        }

        int mid = (start + end) >> 1;
        if (seg[index * 2] < findRank) { //오른쪽에 있음
            return find(mid + 1, end, index * 2 + 1, findRank - seg[index * 2]);
        } else { //왼쪽에 있음
            return find(start, mid, index * 2, findRank);
        }
    }

    private static void update(int start, int end, int node, int place, long diff) {
        if (place < start || end < place) return;
        seg[node] += diff;

        if (start == end) return;
        int mid = (start + end) >> 1;
        if (place <= mid) update(start, mid, node * 2, place, diff);
        else update(mid + 1, end, node * 2 + 1, place, diff);
    }
}
