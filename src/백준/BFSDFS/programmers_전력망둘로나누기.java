package 백준.BFSDFS;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_전력망둘로나누기 {

    //각 노드에 연결되어있는 노드의 정보를 담음
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();


    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {

            for (int j = 0; j < n; j++)
                graph.add(new ArrayList<Integer>());


            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int s = wires[j][0]-1;
                int e = wires[j][1]-1;
                graph.get(s).add(e);
                graph.get(e).add(s);
            }

            int cnt1 = 1;
            int cnt2 = 1;
            int start1 = wires[i][0]-1;
            int start2 = wires[i][1]-1;

            boolean visit[] = new boolean[n];

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start1);
            visit[start1]=true;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int j = 0; j < graph.get(now).size(); j++) {
                    if(visit[graph.get(now).get(j)])continue;
                    queue.offer(graph.get(now).get(j));
                    visit[graph.get(now).get(j)]= true;
                    cnt1++;
                }
            }

            visit[start2]=true;
            queue.clear();
            queue.offer(start2);
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int j = 0; j < graph.get(now).size(); j++) {
                    if(visit[graph.get(now).get(j)])continue;
                    queue.offer(graph.get(now).get(j));
                    visit[graph.get(now).get(j)]= true;
                    cnt2++;
                }
            }

            System.out.println(cnt1 + " " + cnt2);
            graph.clear();
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new programmers_전력망둘로나누기().solution(3, new int[][]{{1, 2},{2,3}}));
    }
}
