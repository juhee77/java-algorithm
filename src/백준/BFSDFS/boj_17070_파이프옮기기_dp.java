package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17070_파이프옮기기_dp {

    private static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        map = new int[line][line];
        int[][][] visited = new int[line][line][3];
        //입력구간
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][1][0] = 1;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                if (map[i][j] == 1) continue;
                if (i == 0 && j < 2) continue;

                //가로로 가는경우
                if (j - 1 >= 0)
                    visited[i][j][0] = visited[i][j - 1][0] + visited[i][j - 1][2];

                //세로로 가는 경우
                if (i - 1 >= 0) visited[i][j][1] = visited[i - 1][j][1] + visited[i - 1][j][2];

                //대각선으로 가는경우
                if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {//대각선
                    visited[i][j][2] = visited[i - 1][j - 1][0] + visited[i - 1][j - 1][1] + visited[i - 1][j - 1][2];
                }


            }

        }

        System.out.println(visited[line - 1][line - 1][0] + visited[line - 1][line - 1][1] + visited[line - 1][line - 1][2]);

    }
}

