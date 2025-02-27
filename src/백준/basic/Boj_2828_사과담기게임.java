package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2828_사과담기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int beforeStart = 0;

        int fruitsCnt = Integer.parseInt(br.readLine());
        int movedCnt = 0;
        while (fruitsCnt-- > 0) {
            int beforeEnd = beforeStart + m - 1;
            int droppedPlace = Integer.parseInt(br.readLine()) - 1;
            if (droppedPlace < beforeStart) {
                movedCnt += (beforeStart - droppedPlace);
                beforeStart = droppedPlace;
            } else if (beforeEnd < droppedPlace) {
                movedCnt += (droppedPlace - beforeEnd);
                beforeStart = Math.min(n - m, droppedPlace - m + 1);
            }
        }
        System.out.println(movedCnt);
    }
}
