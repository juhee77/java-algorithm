package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class H_좌표정렬 {
    private static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            return x - o.x;
        }
    }


//    class Point implements Comparable<Point> {
//        public int x, y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public int compareTo(Point o) {
//            if (this.x == o.x) return this.y - o.y;
//            else return this.x - o.x;
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr));
        System.out.println("H_좌표정렬.main");
        System.out.println(solution2(n,arr));
    }

    private static String solution(int n, int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            sb.append(ints[0]).append(" ").append(ints[1]).append("\n");
        }

        return sb.toString();
    }

    public static String solution2(int n, int[][] arr2) {
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Point(arr2[i][0], arr2[i][1]));
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Point o : arr) sb.append(o.x).append(" ").append(o.y).append("\n");
        return sb.toString();
    }
}
