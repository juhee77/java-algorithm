package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * h,w,
 * map(h..W)
 * . 가능, * 벽, $ 문서 , 대문자 문, 소문자 열쇠
 * 소문자 키로 대문자 문 열 수 있다.
 * 마지막줄 상근이가 가지고 있는 열쇠, 열쇠 없으면 0
 * 처음에는 빌딩의 가장자리의 벽이아닌곳을 통해 드나들 수 있다.
 * 열쇠는 여러개 나올 수 있고 어떠한 열쇠로 해당 문자의 어떤 문도 열 수 있다.
 * 상근 이가 훔칠 수 있는 문서의 합
 * <p>
 * 1. 한 방문 점을 여러번 방문 가능하고 열쇠를 획득할 수 만 있다면 가능하다.
 * 2. 일단 가장 자리에서 들어갈 수 있는 모든 경우에 대해서 열쇠를 획득할때 마다 반복한다.
 * 3. 열쇠를 얻으면서 계속 해서 문저를 탐색한다.
 * 4. 더 이상 얻은 키가 없다면 멈춘다.
 */
public class boj_9328_열쇠 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] map;
    public static int row, col;
    private static final ArrayList<Point> canEntry = new ArrayList();
    public static HashSet<Character> havingKeys = new HashSet<>();
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int doc = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            map = new char[row][col];
            canEntry.clear();
            havingKeys.clear();

            scanMap();

            //key 파악
            String key = br.readLine();
            if (key.charAt(0) != '0') {
                for (int i = 0; i < key.length(); i++) {
                    havingKeys.add(key.charAt(i));
                }
            }

            while (true) {
                if (!find()) break;
            }

            sb.append(doc).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean find() {
        //TODO 맵 탐색
        doc = 0;
        boolean[][] visited = new boolean[row][col];
        for (Point point : canEntry) {
            // 벽이 아닌경우 키가 있는 경우 그냥 통과 가능한 경우
            int i = point.x, j = point.y;
            if(visited[i][j]) continue;
            if (map[i][j] == '*') continue;
            if (Character.isUpperCase(map[i][j]) && !havingKeys.contains(Character.toLowerCase(map[i][j])))
                continue; //문인데 열수 없는 문인 경우
            if (Character.isLowerCase(map[i][j]) && !havingKeys.contains(map[i][j])) { //새로운 열쇠를 획득한 경우 다시 시작
                havingKeys.add(map[i][j]);
                return true;
            }

            if (map[i][j] == '$') {
                doc++;
            }
            if (bfs(visited, i, j)) return true;
        }

        return false;
    }

    private static boolean bfs(boolean[][] visited, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int[] dir : dirs) {
                int movedX = now.x + dir[0];
                int movedY = now.y + dir[1];
                if (movedX < 0 || row <= movedX || movedY < 0 || col <= movedY) continue; //범위 벗어난 경우
                char nowOn = map[movedX][movedY];
                if (nowOn == '*') continue; //벽인 경우
                if (visited[movedX][movedY]) continue; //이미 방문
                if (Character.isUpperCase(nowOn) && !havingKeys.contains(Character.toLowerCase(nowOn)))
                    continue; // 문인데 키가 없는 문인 경우

                if (Character.isLowerCase(nowOn)) { //키 인 경우
                    if (!havingKeys.contains(nowOn)) { //없는 키를 획득 한 경우
                        havingKeys.add(nowOn);
                        return true; //다시 시작
                    }
                }
                if (nowOn == '$') {
                    doc++;
                }
                queue.add(new Point(movedX, movedY));
                visited[movedX][movedY] = true;
            }
        }
        return false;
    }


    private static void scanMap() throws IOException {
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp.substring(j, j + 1).charAt(0);
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (map[i][j] != '*') {
                        canEntry.add(new Point(i, j));
                    }
                }
            }
        }
    }
}
