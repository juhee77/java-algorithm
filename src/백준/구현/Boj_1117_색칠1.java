package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1117_색칠1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        //미리 영향을 받은 사각형의 넓이를 구한다.
        long area = (long) (x2 - x1) * (y2 - y1) * (c + 1);

        if (f <= w / 2) {
            // 접은 경우 넘어가지 않는 경우
            if (f <= x1) {
                //세로 범위안에 겹치는게 없음
                System.out.println(w * h - area);
            } else {
                System.out.println(w * h - (area + (long) (Math.min(f, x2) - x1) * (y2 - y1) * (c + 1)));
            }
        } else {
            // 접은 경우 넘어가는 경우*접은 부분 계산)
            if (w <= x1 + f) {
                System.out.println(w * h - area);
            } else {
                System.out.println(w * h - (area + (Math.min(w, f + x2) - (f + x1)) * (y2 - y1) * (c + 1)));
            }
        }
    }
}