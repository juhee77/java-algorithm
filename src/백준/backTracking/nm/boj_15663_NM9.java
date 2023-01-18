package 백준.backTracking.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_15663_NM9 {

    static StringBuilder sb = new StringBuilder();
    static Integer[] arr;
    static boolean[] visit;
    static int[] input;
    static HashSet<String> hash=new HashSet<>();

    private static void dfs(int n, int m, int d) {
        if (d == m) {

            StringBuilder temp= new StringBuilder();
            for(int a : arr) temp.append(a).append(" ");
            if(!hash.contains(temp.toString())){
                sb.append(temp + "\n");
                hash.add(temp.toString());
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[d] = input[i];
                dfs(n, m, d + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        input = new int[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++)
            input[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(input);

        arr = new Integer[y];
        visit = new boolean[x];
        dfs(x, y, 0);

        System.out.print(sb);

    }
}
