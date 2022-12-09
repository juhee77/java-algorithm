package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10974_모든순열 {
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int size = Integer.parseInt(br.readLine());
        visited = new boolean[size];
        arr =new int[size];
        backtracking(size, 0);
        System.out.println(sb);
    }

    private static void backtracking(int size, int depth) {
        if (size == depth) {
            for (int e : arr) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                arr[depth]=i+1;
                visited[i]=true;
                backtracking(size,depth+1);
                visited[i]=false;
            }
        }
    }
}
