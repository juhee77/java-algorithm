package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16724_피리부는사나이 {
    private static int col = 0, row = 0;
    private static char[][] map;
    private static int[][] visited;
    private static int cnt = 0;
    private static int idx = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        visited = new int[row][col];

        /*input*/
        for (int i = 0; i < row; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = tmp[j];
            }
        }

        /*탐색 길 따라가면서 */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }


        System.out.println(cnt);

    }

    private static void bfs(int i, int j) {
        //현재 노드 탐색 확인
        visited[i][j] = idx;
        //이동하는 칸
        int[] move = getNowt(map[i][j]);
        int movex = i + move[0];
        int movey = j + move[1];

        if (visited[movex][movey] == 0) {
            bfs(movex, movey); //만약 탐색 되지 않은공간 이면 계속 해서 탐색
        }
        else {
            if (visited[movex][movey] == idx) { //싸이클이 생겼는데 이번턴에서만 사이클만 있다면 safezonet++
                cnt++;
            }
            idx++; // 이번턴과 다음턴을 분리하기 위해서
        }
    }

    private static int[] getNowt(char now) {
        switch (now) {
            case 'U':
                return new int[]{-1, 0};

            case 'D':
                return new int[]{1, 0};

            case 'L':
                return new int[]{0, -1};

            case 'R':
                return new int[]{0, 1};
        }
        return new int[]{00}; //ERROR
    }
}
