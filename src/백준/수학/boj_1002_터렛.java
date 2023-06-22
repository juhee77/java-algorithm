package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1002_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            //두 사람 사이의 거리
            int mid = (int) (Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));

            if (x == x2 && y == y2 && r == r2) {
                if (r == 0) sb.append("1" + "\n"); //같은 점에 반지름이 0인경우 한점 뿐이다.
                else sb.append("-1" + "\n");//같은경우(무한대)
            } else if (mid > Math.pow(r + r2, 2)) sb.append("0" + "\n"); //내부에 있음
            else if (mid < Math.pow(r - r2, 2)) sb.append("0" + "\n"); // 접점이 없음
            else if (mid == Math.pow(r - r2, 2)) sb.append("1" + "\n");//내접
            else if (mid == Math.pow(r + r2, 2)) sb.append("1" + "\n");//외접
            else sb.append("2" + "\n");//외접
        }
        System.out.println(sb);
    }
}
