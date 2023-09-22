package 백준.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16566_카드게임 {
    private static int m;
    private static final List<Integer> cards = new ArrayList<>();
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        parents = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
            parents[i] = i;
        }

        Collections.sort(cards);
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < k; j++) {
            int temp = Integer.parseInt(st.nextToken());
            //upperbound를 구한다.
            int index = upperBound(temp);
            index = find(index);
            bw.write(cards.get(index) + "\n");
            union(index, index + 1);
        }

        bw.flush();
        bw.close();
    }

    private static int find(int index) {
        if (index == parents[index]) {
            return index;
        }

        return parents[index] = find(parents[index]);
    }

    public static void union(int a, int b) {
        if (b >= m) {
            return;
        }

        a = find(a);
        b = find(b);

        parents[a] = b; //더 큰숫자를 지정
    }

    public static int upperBound(int x) {
        int start = 0;
        int end = m;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (cards.get(mid) <= x) {
                start = mid + 1;
            } else if (cards.get(mid) >= x) {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }


}
