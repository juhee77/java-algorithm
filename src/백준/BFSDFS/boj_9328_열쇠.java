package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_9328_열쇠 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static char arr[][];
    public static int row, col;
    public static ArrayList<Point> canEntry = new ArrayList();
    public static HashSet<Character> havingKeys;

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            arr = new char[row][col];
            canEntry.clear();
            scanMap();

            //key 파악
            String key = br.readLine();
            while(key.charAt(0)!='0'){
                havingKeys.add(key.charAt(0));
                key = key.substring(1);
            }

            bfs();


        }
    }

    private static void bfs() {
        //TODO 맵 탐색
        boolean visited[][] = new boolean[row][col];
    }

    private static void scanMap() throws IOException {
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = temp.substring(j, j + 1).charAt(0);
            }
        }
    }
}
