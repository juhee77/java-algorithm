package 백준.graph.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14567_선수과목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> outGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            outGraph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        int[] semesters = new int[n];

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            outGraph.get(start).add(end);
            inDegree[end]++;
        }


        //topological sort 위상정렬 과정
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int semester = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            semester++;
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                semesters[now] = semester;
                for (Integer next : outGraph.get(now)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) queue.add(next);
                }
            }
        }

        //output
        for (int i : semesters) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
