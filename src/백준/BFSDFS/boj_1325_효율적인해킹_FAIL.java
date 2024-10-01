package 백준.BFSDFS;

import java.io.*;
import java.util.*;

public class boj_1325_효율적인해킹_FAIL {

    static boolean[] visit;
    static int[] victims;
    static int max = Integer.MIN_VALUE;
    static int n, m;
    static ArrayList<ArrayList<Integer>> outGraph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            outGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            outGraph.get(b).add(a);
        }

        victims = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {

                int depths = dfs(i);
                if (max < depths) {
                    max = depths;
                    sb = new StringBuilder((i+1) + " ");
                } else if (max == depths) {
                    sb.append((i+1)).append(" ");
                }
            }
        }

//        System.out.println(Arrays.toString(victims));
        System.out.println(sb);
    }

    public static int dfs(int x) {
        if (visit[x]) return victims[x];
        visit[x] = true;

        int victimsCnt = 1;
        for (int i : outGraph.get(x)) {
            victimsCnt += dfs(i);
        }

        return victims[x] = victimsCnt;
    }
}