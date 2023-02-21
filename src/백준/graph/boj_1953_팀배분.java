package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1953_팀배분 {
    private static boolean[] visited;
    private static List<Integer>[] hates;
    private static final List<Integer>[] teams = new List[2];
    private static final StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        //init
        visited = new boolean[n + 1];
        hates = new List[n + 1];
        for (int i = 0; i < 2; i++) {
            teams[i] = new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            hates[i] = new ArrayList<>();
        }

        //input
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                hates[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        //solution
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
        }

        //output
        setTeam(teams[0]);
        setTeam(teams[1]);
        System.out.println(sb);
    }

    private static void setTeam(List<Integer> team) {
        Collections.sort(team);
        sb.append(team.size()).append("\n");
        for (Integer now : team) {
            sb.append(now).append(" ");
        }
        sb.append("\n");
    }


    private static void dfs(int start, int nowCnt) {
        if (!visited[start]) {
            visited[start] = true;
            teams[nowCnt % 2].add(start);
            for (Integer hate : hates[start]) {
                dfs(hate, nowCnt + 1);
            }
        }
    }
}
