package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2606_웜바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int vertex = Integer.parseInt(br.readLine());
        int arr[][] = new int[vertex+1][vertex+1];
        int visited[] =new int[vertex+1];
        int edge = Integer.parseInt(br.readLine());

        for(int i=0;i<edge;i++){
            st=new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            arr[v1][v2]=arr[v2][v1]=1;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        visited[1]=1;

        int cnt =0;
        while(!stack.isEmpty()){
            int temp = stack.pop();
//            System.out.println(temp); // 방문노드 확인
            for(int i=1;i<=vertex;i++){
                if(arr[temp][i]==1 && visited[i]==0) {
                    visited[i]=1;
                    stack.push(i);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
