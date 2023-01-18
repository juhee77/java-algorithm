package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17386_선분교차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int ax1 = Integer.parseInt(st.nextToken());
        int ay1 = Integer.parseInt(st.nextToken());
        int ax2 = Integer.parseInt(st.nextToken());
        int ay2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bx1 = Integer.parseInt(st.nextToken());
        int by1 = Integer.parseInt(st.nextToken());
        int bx2 = Integer.parseInt(st.nextToken());
        int by2 = Integer.parseInt(st.nextToken());


        //만약 x의 증가량이 없다면 y=n임
        if (ax1 == ax2 && bx1 == bx2) {
            int minAy = getMin(ay1, ay2);
            int maxAy = getMax(ay1, ay2);
            int minBy = getMin(by1, by2);
            int maxBy = getMax(by1, by2);

            if (ax1 == bx1 && ((minAy <= minBy && minBy < maxAy) || (minAy <= maxBy && maxBy < maxAy) || (minBy <= minAy && minAy < maxBy) || (minBy <= maxAy && maxAy < maxBy)))
                System.out.println(1);
            else System.out.println(0);
        } else if (ax1 == ax2) {
            double bInclination = getInclination(bx1, by1, bx2, by2);
            double bYDot = getYDot(bInclination, bx1, by1);

            double ansY = bInclination * ax1 + bYDot;

            if (checkingRange(ax1, ansY, ax1, ay1, ax2, ay2) && checkingRange(ax1, ansY, bx1, by1, bx2, by2))
                System.out.println(1);
            else System.out.println(0);
        } else if (bx1 == bx2) {
            double aInclination = getInclination(ax1, ay1, ax2, ay2);
            double aYDot = getYDot(aInclination, ax1, ay1);

            double ansY = aInclination * bx1 + aYDot;

            if (checkingRange(bx1, ansY, ax1, ay1, ax2, ay2) && checkingRange(bx1, ansY, bx1, by1, bx2, by2))
                System.out.println(1);
            else System.out.println(0);
        } else {
            double aInclination = getInclination(ax1, ay1, ax2, ay2);
            double bInclination = getInclination(bx1, by1, bx2, by2);

            double aYDot = getYDot(aInclination, ax1, ay1);
            double bYDot = getYDot(bInclination, bx1, by1);

//            System.out.println("aInclination = " + aInclination);
//            System.out.println("aYDot = " + aYDot);
//            System.out.println("bInclination = " + bInclination);
//            System.out.println("bYDot = " + bYDot);


            double ansX = (bYDot - aYDot) / (aInclination - bInclination);
            double ansY = aInclination * ansX + aYDot;

            if (checkingRange(ansX, ansY, ax1, ay1, ax2, ay2) && checkingRange(ansX, ansY, bx1, by1, bx2, by2)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    //double 형 9.999999로 출력된다.
    private static boolean checkingRange(double ansX, double ansY, int x1, int y1, int x2, int y2) {
        int minY = getMin(y1, y2);
        int maxY = getMax(y1, y2);
        int minX = getMin(x1, x2);
        int maxX = getMax(x1, x2);

        return (minY <= ansY && ansY <= maxY) && (minX <= ansX && ansX <= maxX);
    }

    private static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    private static int getMin(int a, int b) {
        return Math.min(a, b);
    }

    private static double getInclination(int x1, int y1, int x2, int y2) {
        return ((double) y2 - y1) / (x2 - x1);
    }

    private static double getYDot(double inclination, int x, int y) {
        return y - inclination * x;
    }

}