package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크_조합 {
    private static boolean visited[];
    private static int map[][];
    private static int min = Integer.MAX_VALUE;

    private static void solution(int n, int d,int start) {
        if (n == d) {
            int sum =0;
            for(int i=0;i<n*2;i++){
                for(int j=0;j<n*2;j++){
                    if(visited[i] && visited[j]) sum += map[i][j];
                    else if(!visited[i]&&!visited[j]) sum-=map[i][j];
                }
            }

            min = Math.min(min, Math.abs(sum));
        } else {
            for (int i = start ; i < n * 2; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    solution(n,d+1,i);
                    visited[i]=false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        map = new int[num][num];
        visited = new boolean[num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(num / 2, 0,0);
        System.out.println(min);
    }
}
