package 백준.graph;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9466_텀프로젝트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while(TC --> 0){
            int num = Integer.parseInt(br.readLine());
            int array[]= new int[num+1];
            int visited[] = new int[num+1];
            int alone = 0;

            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=num;j++) {
                array[j]=Integer.parseInt(st.nextToken());
            }


            for(int i=1;i<=num;i++){
                if(visited[i]!=0)continue; //이미 방문함
                Queue<Integer> q = new LinkedList<>();
                ArrayList<Integer> nowturn = new ArrayList<>();
                q.add(i);
                int now = 1;
                visited[i]=now++;
                nowturn.add(i);

                while(!q.isEmpty()){
                    int a = q.poll();

                    int next = array[a];//다음
                    if(visited[next]!=0){
                        if(!nowturn.contains(next))alone += visited[a];
                        else alone += visited[next]-1;
                        break;
                    }
                    nowturn.add(next);
                    visited[next]=now++;
                    q.add(next);

                }
            }
            sb.append(alone).append("\n");
        }
        System.out.println(sb);
    }
}
/*
8
6
2 3 4 5 6 2
5
2 5 4 5 2
6
1 3 4 3 2 6
13
2 4 5 2 4 1 8 9 10 11 9 10 10
10
2 5 7 1 6 8 8 3 5 10
10
2 7 10 5 3 3 9 10 6 3
6
2 1 1 2 6 3
3
2 3 2
 */
