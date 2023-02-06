package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_16946_벽부수고이동하기4 {
    private static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int row, col;
    private static int[][] map;
    private static final HashMap<Integer, Integer> depthMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        int[][] ans = new int[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        //이어진 0의 값(dp), 각 연결된 땅의 이름(map, laneName 을 이용해서 저장)
        int landName = 100;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    bfsFindZero(i, j, landName++);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) {
                    ArrayList<Integer> visitedLandName = new ArrayList<>(); //방문했던 땅의이름을 저장하기 위해서
                    int temp = 1; //현재위치
                    for (int[] ints : dir) {
                        int moveX = i + ints[0];
                        int moveY = j + ints[1];
                        if (moveX < 0 || moveY < 0 || row <= moveX || col <= moveY) continue; //범위 벗어남
                        if (visitedLandName.contains(map[moveX][moveY])) continue; //이미 방문함
                        if (map[moveX][moveY] < 100) continue; // 없는 땅

                        visitedLandName.add(map[moveX][moveY]);// 방문한 땅 체크
                        temp = (temp + depthMap.get(map[moveX][moveY])) % 10;
                    }
                    ans[i][j] = temp % 10;
                }

                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfsFindZero(int i, int j, int landName) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(i, j));

        int depth = 0;
        while (!stack.isEmpty()) {
            Point now = stack.pop();
            if (map[now.x][now.y] > 0) continue; //이미 방문함
            map[now.x][now.y] = landName; //땅의 영역을 표시
            depth++;

            for (int[] ints : dir) {
                int moveX = now.x + ints[0];
                int moveY = now.y + ints[1];
                if (moveX < 0 || moveY < 0 || row <= moveX || col <= moveY) continue;
                if (map[moveX][moveY] == 0) {
                    stack.push(new Point(moveX, moveY));
                }
            }
        }
        depthMap.put(landName, depth % 10);
    }
}
