package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_10655_마라톤RE {
    private static final List<Point> allPoints = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            allPoints.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int allSum = 0;
        int[] diff = new int[size];
        for(int i = 1; i< size; i++){
            diff[i] =  allPoints.get(i).distance(allPoints.get(i-1));
            allSum += diff[i];
        }

        for(int i = 1; i< size -1; i++){
            //건너띄는 경우
            int checked = allSum - diff[i]-diff[i+1];
            checked += allPoints.get(i+1).distance(allPoints.get(i-1));
            min = Math.min(min, checked);
        }

        System.out.println(min);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }
    }
}
