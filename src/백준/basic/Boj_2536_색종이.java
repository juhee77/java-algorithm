package 백준.basic;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2536_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        //색종이의 사이즈는 10
        List<int[]> queue = new ArrayList<>();
        int sum = 100 * n;
        while (n-- > 0) {
            HashSet<Point> points = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int[] current : queue) {
                //현재 것과 겹치는 범위 계산
                int startX = current[0];
                int startY = current[1];
                int holdX = 0;
                int saveX = 0;
                int saveY = 0;
                int holdY = 0;
                holdX = getHold(x, startX, holdX);

                if (holdX == 0) continue;
                holdY = getHold(y, startY, holdY);

                Point temp = new Point(saveX, saveY);
                if (holdY != 0 && !points.contains(temp)) {
                    points.add(temp);
                    sum -= holdX * holdY;
                }

            }
            queue.add(new int[]{x, y});
        }
        System.out.println(sum);
    }

    private static int getHold(int y, int startY, int holdY) {
        int saveY;
        if (startY <= y && y <= startY + 10) {
            saveY = y;
            holdY = (startY + 10 - y);
        } else if (y <= startY && startY <= y + 10) {
            saveY = startY;
            holdY = (y + 10 - startY);
        }
        return holdY;
    }
}
