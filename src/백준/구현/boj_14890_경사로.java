package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14890_경사로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int map[][] = new int[n][n];
        int mapreverse[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                mapreverse[j][i] = map[i][j];
            }
        }

        int road = getRoad(n, l, map)+getRoad(n, l, mapreverse);
        System.out.println(road);
    }

    private static int getRoad(int n, int l, int[][] map) {
        int road=0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            boolean flag = true;
            boolean chk[] = new boolean[n];
            while (j+l < n && flag) {
                if (map[i][j] - 1 == map[i][j + 1]&& !chk[j+1]) { //만약 바로 다음칸이 줄어야 한다면
                    if (j + l < n) {
                        for (int k = j + 1; k < j + l +1 && flag; k++) {
                            if (map[i][j] - 1 != map[i][k]) flag = false;
                            chk[k]=true;
                        }
                        if (flag) j=j+l;
                        else break;
                    }
                    else flag=false;
                }
                else if(map[i][j] +1 == map[i][j + l]&&!chk[j]){
                    if (j + l < n) {
                        for (int k = j; k < j + l && flag; k++) {
                            if (map[i][j] != map[i][k]) flag = false;
                            chk[k]=true;
                        }
                        if (flag) j=j+l;
                        else break;
                    }
                    else flag=false;
                }
                else if(map[i][j]==map[i][j+1]) j++;
                else flag = false;
            }
            for(;j<n-1;j++){
                if(map[i][j]!= map[i][j+1])flag = false;
            }
            if(flag)road++;

        }
        return road;
    }
}
