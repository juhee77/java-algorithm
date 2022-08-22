package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_11724_연결요소의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int arr[][] = new int[vertex+1][vertex+1];
        int visited[] =new int[vertex+1];

        for(int i=0;i<edge;i++){
            st=new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            arr[v1][v2]=arr[v2][v1]=1;
        }

        int cnt =0;
        for(int i=1;i<=vertex;i++){
            if(visited[i]==0){ //방문하지 않은 노드라면
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(i);
                visited[i]=1;

                while(!stack.isEmpty()){
                    int temp = stack.pop();
//            System.out.println(temp); // 방문노드 확인
                    for(int j=1;j<=vertex;j++){ //주변노드중 반문하지 않았는데 연결된것 모두 방문처리
                        if(arr[temp][j]==1 && visited[j]==0) {
                            visited[j]=1;
                            stack.push(j);
                        }
                    }
                }
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
