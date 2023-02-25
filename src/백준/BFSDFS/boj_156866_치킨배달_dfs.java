package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_156866_치킨배달_dfs {
    private static int min = Integer.MAX_VALUE;
    private static ArrayList<Point> chicken = new ArrayList<>();
    private static ArrayList<Point> house = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static Point[] arr;
    static boolean[] visit;
    static Point[] input;
    static int line;

    private static void dfs(int n, int m, int d, int start) {
        if (d == m) {
            checkMin();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[d] = input[i];
                dfs(n, m, d + 1, i);
                visit[i] = false;
            }
        }
    }

    private static void checkMin() {
        int[][] temp = new int[line][line];
        for (Point tempC : arr) {//치킨집
            for (Point tempH : house) {
                int length = Math.abs(tempC.x - tempH.x) + Math.abs(tempC.y - tempH.y);
                if (temp[tempH.x][tempH.y] == 0) temp[tempH.x][tempH.y] = length;
                else temp[tempH.x][tempH.y] = Math.min(temp[tempH.x][tempH.y], length);
            }
        }

        int tmpMin = 0;
        for (Point tempH : house) {
            tmpMin += temp[tempH.x][tempH.y];
        }
        min = Math.min(tmpMin, min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) house.add(new Point(i, j));
                else if (now == 2) chicken.add(new Point(i, j));
            }
        }
        input = chicken.toArray(new Point[0]);
        arr = new Point[goal];
        visit = new boolean[chicken.size() + 1];
        dfs(chicken.size(), goal, 0, 0);
        System.out.print(sb);
        System.out.println(min);

    }

}
