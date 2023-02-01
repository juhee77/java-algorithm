package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17387_선분교차 {
    private static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point a = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point b = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));


        st = new StringTokenizer(br.readLine());
        Point c = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point d = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        int ans1 = ccw(a, b, c) * ccw(a, b, d);
        int ans2 = ccw(c, d, a) * ccw(c, d, b);

        if (ans1 == 0 && ans2 == 0) {
            if (Math.min(a.x, b.x) <= Math.max(c.x, d.x) && Math.min(c.x, d.x) <= Math.max(a.x, b.x) &&
                    Math.min(a.y, b.y) <= Math.max(c.y, d.y) && Math.min(c.y, d.y) <= Math.max(a.y, b.y)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (ans1 <= 0 && ans2 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static int ccw(Point a, Point b, Point c) {
        long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.x * c.y + c.x * b.y + b.x * a.y);
        if (result == 0) return 0;
        else if (result > 0) return 1;
        else return -1;
    }
}
