package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2667_단지번호 {
    private static int dfs(int arr[][], int x, int y) {
        if (x >= arr.length || x < 0 || y < 0 || y >= arr[0].length) return 0;

        //방문안한 노드이면
        if (arr[x][y] == 1) {
            arr[x][y] = 0;

            return dfs(arr, x - 1, y) + dfs(arr, x + 1, y)
                    + dfs(arr, x, y - 1) + dfs(arr, x, y + 1) + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        int arr[][] = new int[line][line];
        //입력구간
        for (int i = 0; i < line; i++) {
            String s = br.readLine();
            for (int j = 0; j < line; j++)
                arr[i][j] = Integer.parseInt(s.substring(j, j + 1));
        }

        //dfs
        ArrayList<Integer> num = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line; j++) {
                if (arr[i][j] == 1) {
                    int temp=dfs(arr, i, j);
                    if (temp!=0){
                        cnt++;
                        num.add(temp);
                    }
                }
            }
        }

        //단지수
        sb.append(cnt).append('\n');

        //오룸차순 정렬
        Collections.sort(num);

        for(int e: num) sb.append(e+"\n");
        System.out.println(sb);
    }
}
