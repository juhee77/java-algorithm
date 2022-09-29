package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17144_미세먼지안녕 {
    private static int arr[][];
    private static int cnt = 0;
    private static int[] dirx = {-1, 0, 1, 0};
    private static int[] diry = {0, 1, 0, -1};
    private static int head = -1, tail = -1;

    private static int[][] pollution(int x, int y) {
        int nowx, nowy;
        int arrc[][] = new int[x][y];


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == 0) continue;
                else if (arr[i][j] == -1) arrc[i][j] = -1;
                else {
                    int polution = arr[i][j] / 5;
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        nowx = i + dirx[k];
                        nowy = j + diry[k];

                        if (nowx < 0 || arr.length <= nowx || nowy < 0 || arr[0].length <= nowy) continue;//범위를 넘어감(벽)
                        if (arr[nowx][nowy] == -1) continue;//공기청정기
                        else {
                            cnt++;
                            arrc[nowx][nowy] += polution;
                        }
                    }
                    arrc[i][j] += arr[i][j] - polution * cnt;
                }
            }
        }

        return arrc;
    }

    public static void wind() {
        //위에
        for (int i = head - 1; 1 <= i; i--) arr[i][0] = arr[i - 1][0];
        for (int j = 0; j < arr[0].length - 1; j++) arr[0][j] = arr[0][j + 1];

        for (int i = 0; i < head; i++) arr[i][arr[0].length - 1] = arr[i + 1][arr[0].length - 1];
        for (int j = arr[0].length - 1; 1 < j; j--) arr[head][j] = arr[head][j - 1];
        arr[head][1] = 0;
        arr[head][0] = -1;
        //아래
        for (int i = tail + 1; i < arr.length - 1; i++) arr[i][0] = arr[i + 1][0];
        for (int j = 0; j < arr[0].length - 1; j++) arr[arr.length - 1][j] = arr[arr.length - 1][j + 1];

        for (int i = arr.length - 1; tail <= i; i--) arr[i][arr[0].length - 1] = arr[i - 1][arr[0].length - 1];
        for (int j = arr[0].length - 1; 1 < j; j--) arr[tail][j] = arr[tail][j - 1];
        arr[tail][1] = 0;
        arr[tail][0] = -1;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        arr = new int[x][y];


        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (head == -1) head = i;
                    else tail = i; //어차피 y는 0임
                }
            }
        }

        while (time-- > 0) {
            arr = pollution(x, y);
            wind();
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != -1) ans += arr[i][j];
            }
        }

        System.out.println(ans);
    }
}
/*
5 5 1
-1 6 7 8 9
-1 10 11 12 13
1 2 3 4 5
14 15 16 17 18
20 21 22 23 24


6 2 1
-1 1
-1 2
3 4
5 6
7 8
9 10


6 2 1
3 4
5 6
7 8
9 10
-1 1
-1 2
 */