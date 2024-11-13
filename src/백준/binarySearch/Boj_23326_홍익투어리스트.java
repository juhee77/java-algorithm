package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj_23326_홍익투어리스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        TreeSet<Integer> arr = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++)
            if (st.nextToken().charAt(0) == '1') arr.add(i);

        int now = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == '1') {
                int parseInt = Integer.parseInt(st.nextToken()) - 1;
                if (arr.contains(parseInt))
                    arr.remove(parseInt);
                else arr.add(parseInt);
            } else if (command == '2') {
                int mvCnt = Integer.parseInt(st.nextToken());
                now = (int) (((long) now + mvCnt) % a);
            } else if (command == '3') {
                if (arr.isEmpty()) sb.append("-1");
                else {
                    //자신의 현 위치를 포함하여 가장 가까운 것.
                    Integer next = arr.ceiling(now);
                    next = (next == null) ? arr.first() : next;
//                    System.out.println(arr + " " + now + " " + next + " " );
                    next = (next >= now) ? next - now : a - now + next;
                    sb.append(next);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
