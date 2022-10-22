package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14888_연산끼워넣기{
    private static int visited[];
    private static int nums[];
    private static int maxs[];
    private static int max= Integer.MIN_VALUE,min= Integer.MAX_VALUE;

    private static void dfs(int n, int d, int tmpsum) {
        if (n == d) {

            max= Math.max(max, tmpsum);
            min= Math.min(min, tmpsum);
        } else {
            for (int k = 0; k < 4; k++) {
                if (visited[k] <maxs[k]) {
                    visited[k] += 1;
                    switch (k) {
                        case 0:
                            dfs(n, d + 1, tmpsum +nums[d]);
                            break;
                        case 1:
                            dfs(n, d + 1, tmpsum -nums[d]);
                            break;
                        case 2:
                            dfs(n, d + 1, tmpsum *nums[d]);
                            break;
                        case 3:
                            dfs(n, d + 1, tmpsum /nums[d]);
                            break;
                    }

                    visited[k] -= 1;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums= new int[n];
        visited= new int[4]; //사칙연삭 기록
        maxs= new int[4]; //+ - * /
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)maxs[i] = Integer.parseInt(st.nextToken());
        dfs(n, 1,nums[0]);
        System.out.println(max+ "\n" +min);
    }
}
