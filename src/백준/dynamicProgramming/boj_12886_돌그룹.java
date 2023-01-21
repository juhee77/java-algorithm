package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12886_돌그룹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solution(a, b, c));
    }

    private static int solution(int a, int b, int c) {
        if (((double) a + b + c) % 3 != 0) {
            return 0;
        }

        if (a == b && b == c) {
            return 1;
        }

        int sum = a + b + c;
        boolean[][] arr = new boolean[1501][1501];

        Queue<int[]> q = new LinkedList<>();
        int[] init = {a, b};
        q.add(init);
        arr[a][b] = true; //뒤에가 큰
        boolean flag = false;

        while (!q.isEmpty() && !flag) {
            int[] now = q.poll();

            int[] nowTemp = new int[]{now[0], now[1], sum - now[0] - now[1]};
            Arrays.sort(nowTemp);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (nowTemp[i] < nowTemp[j]) {
                        int x = nowTemp[i] + nowTemp[i];
                        int y = nowTemp[j] - nowTemp[i];
                        if (x == sum/3 && y==sum/3) {
                            //3개가 일치한 경우
                            flag = true;
                        }

                        if (isRangeOver(x,y)) continue; // 범위를 벗어난 경우
                        if (!arr[x][y]) {
                            q.add(new int[]{x,y});
                            arr[x][y] = true;
                        }
                    }
                }

            }
        }
        if (flag) return 1;
        return 0;
    }

    private static boolean isRangeOver(int x,int y) {
        return x < 0 || 1500 < x || y < 0 || 1500 < y;
    }
}
