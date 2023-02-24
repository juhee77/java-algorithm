package 백준.backTracking.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15664_NM10 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static List<Integer> input = new ArrayList<>();
    static HashSet<String> hash =new HashSet<>();


    private static void dfs(int n, int m, int d,int start) {
        if (d == m) {

            StringBuilder temp= new StringBuilder();
            for(int a : arr) temp.append(a).append(" ");
            if(!hash.contains(temp.toString())){
                sb.append(temp).append("\n");
                hash.add(temp.toString());
            }
            return;
        }

        for (int i = start; i < n; i++) {
                arr[d] = input.get(i);
                dfs(n, m, d + 1,i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++)
            input.add(Integer.parseInt(st.nextToken()));

        Collections.sort(input);
        arr = new int[y];
        dfs(x, y, 0,0);

        System.out.print(sb);

    }
}
