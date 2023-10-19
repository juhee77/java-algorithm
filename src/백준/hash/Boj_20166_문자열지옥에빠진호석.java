package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_20166_문자열지옥에빠진호석 {
    private static final HashMap<String, Integer> dictionary = new HashMap<>();
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        char[][] map = new char[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                Queue<Idol> q = new LinkedList<>();
                String key = map[i][j] + "";
                q.add(new Idol(key, i, j));
                dictionary.put(key, dictionary.getOrDefault(key, 0) + 1);

                for (int mv = 1; mv < 5; mv++) {
                    int size = q.size();
                    for (int p = 0; p < size; p++) {
                        Idol now = q.poll();

                        for (int[] dir : dirs) {
                            int tempX = (now.x + dir[0] + row) % row;
                            int tempY = (now.y + dir[1] + col) % col;

                            String newKey = now.key + map[tempX][tempY];
                            dictionary.put(newKey, dictionary.getOrDefault(newKey, 0) + 1);
                            q.add(new Idol(newKey,tempX,tempY));
                        }
                    }
                }
            }
        }

        while (tc-- > 0) {
            sb.append(dictionary.getOrDefault(br.readLine(), 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static class Idol{
        String key;
        int x,y;

        public Idol(String key, int x, int y) {
            this.key = key;
            this.x = x;
            this.y = y;
        }
    }
}
