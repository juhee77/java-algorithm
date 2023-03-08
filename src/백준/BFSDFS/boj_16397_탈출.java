package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16397_탈출 {

    public static final int MAX_RANGE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //시작 숫자
        int t = Integer.parseInt(st.nextToken()); //버튼 누를 수 있는 최대 수
        int g = Integer.parseInt(st.nextToken()); //만드려는 숫자

        if (!find(n, t, g)) {
            System.out.println("ANG"); //찾지 못한 경우
        }
    }

    private static boolean find(int n, int t, int g) {
        boolean[] visited = new boolean[MAX_RANGE];
        //0: 현재 숫자  , 1 클릭한 횟수
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n]=true;

        while (!queue.isEmpty()) {
            int sz = queue.size();

            //bfs(모든 것을 탐색하면서 확인한다)
            for (int i = 0; i < sz; i++) {
                int[] poll = queue.poll();
                if(poll[0]==g) {
                    System.out.println(poll[1]); //찾음
                    return true;
                }
                if(poll[1]>=t) continue; //클릭할 수 있는 횟수를 지남, 더 이상 의미가 없음 다음걸로 진행

                checkNext(visited, queue, poll, poll[0]+1); //+1

                if(poll[0]!=0) {
                    int next = poll[0]*2;
                    if(next>=MAX_RANGE) continue; //범위 채크
                    int temp = (int)Math.pow(10, (int) Math.log10(next));
                    next-=temp; //제일 앞자리 숫자 하나를 뺸다
                    checkNext(visited, queue, poll, next); //*2-제일 앞자리 숫자 하나 빼기
                }
            }
        }
        return false;
    }

    private static void checkNext(boolean[] visited, Queue<int[]> queue, int[] poll, int next) {
        if (0<=next && next<MAX_RANGE && !visited[next]) {
            visited[next] = true;
            queue.add(new int[]{next, poll[1] + 1});
        }
    }
}
