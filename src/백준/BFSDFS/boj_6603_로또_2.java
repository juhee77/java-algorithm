package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603_로또_2 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int next = Integer.parseInt(st.nextToken());
        while (next != 0) {
            int[] arr = new int[next];
            int[] visited = new int[6];

            for (int i = 0; i < next; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(arr, visited, 0, 0, next);

            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            next = Integer.parseInt(st.nextToken());

        }

        System.out.println(sb);

    }

    private static void dfs(int[] arr, int[] visited, int d, int start, int n) {
       if(d == 6) { //6개를 뽑는다
            printLotto(visited);
        }
        else {
            for(int i=start;i<n;i++){
                visited[d]=arr[i];
                dfs(arr,visited,d+1,i+1,n);
            }
        }

    }

    private static void printLotto(int[] visited) {
        for (int j : visited) {
            sb.append(j).append(" ");
        }
        sb.append("\n");
    }
}
