package 백준.backTracking;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_2239_스도쿠 {
    static int[][] arr;
    static ArrayList<Point> list = new ArrayList<Point>();
    static boolean totalF = false;

    private static void dfs(int n) {
        if (n == list.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    sb.append(arr[i][j]);
                sb.append("\n");
            }
            System.out.print(sb);
            totalF = true;
            return;
        }
        Point temp = list.get(n);
        for (int i = 1; i < 10; i++) {

            boolean flag = true;
            //가로
            for (int p = 0; p < 9; p++) if (arr[temp.x][p] == i) flag = false;
            if (!flag) continue;
            //세로
            for (int p = 0; p < 9; p++) if (arr[p][temp.y] == i) flag = false;
            if (!flag) continue;
            //사각형
            for (int p = temp.x / 3 * 3; p < (temp.x / 3 + 1) * 3; p++) {
                for (int q = temp.y / 3 * 3; q < (temp.y / 3 + 1) * 3; q++)
                    if (arr[p][q] == i) flag = false;
            }
            if (!flag) continue;

            arr[temp.x][temp.y] = i;
            //System.out.println(temp.toString() + " " + i);
            dfs(n + 1);
            if(totalF) break;
            arr[temp.x][temp.y] = 0;
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
                if (arr[i][j] == 0) list.add(new Point(i, j));
            }
        }
        dfs(0);

    }
}
