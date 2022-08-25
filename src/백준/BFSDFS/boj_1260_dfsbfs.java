package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1260_dfsbfs {
    private static int visited[];
    private static int arr[][];
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int now = stack.pop();
            if(visited[now]==1) continue;

            sb.append((now+1)+" ");
            visited[now]=1;

            for(int i=arr.length-1;0<=i;i--){
                if(arr[now][i]==1 &&visited[i]==0){
                    stack.push(i);
                }
            }
        }
        sb.append("\n");
    }

    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);


        while(!queue.isEmpty()){
            int now = queue.poll();
            if(visited[now]==1) continue;

            sb.append((now+1)+" ");
            visited[now]=1;


            for(int i=0;i<arr.length;i++){
                if(arr[now][i]==1 && visited[i]==0){
                    queue.add(i);
                }
            }
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken())-1;

        arr = new int[v][v];
        //입력구간
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken())-1;
            int sen = Integer.parseInt(st.nextToken())-1;
            arr[fir][sen] =arr[sen][fir]= 1;
        }
        //dfs
        visited = new int[v];
        dfs(start);

        //bfs
        visited = new int[v];
        bfs(start);

        System.out.println(sb);
    }
}
