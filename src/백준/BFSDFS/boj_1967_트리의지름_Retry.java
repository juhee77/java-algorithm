package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1967_트리의지름_Retry {
    private static boolean visited[];
    private static ArrayList<ArrayList<Integer[]>> arr;
    private static int answer = 0;
    private static int id = 0;

    public static void dfs(int x, int cnt) {
        if (answer < cnt) {
            answer = cnt;
            id = x;
        }

        ArrayList<Integer[]> temp = arr.get(x);
        for (int k = 0; k < temp.size(); k++) {
            int e = temp.get(k)[0];
            int w = temp.get(k)[1];
            if (!visited[e]) { //p가 전에 방문 했던
                visited[e] = true;
                int tempcnt = cnt + w;
                dfs(e, tempcnt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            arr.add(new ArrayList<Integer[]>());
        }

        for (int i = 0; i < line - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            arr.get(parent).add(new Integer[]{child, w});
            arr.get(child).add(new Integer[]{parent, w});
        }
        visited = new boolean[line];
        visited[0] = true;
        dfs(0, 0);

        visited = new boolean[line];
        visited[id] = true;
        dfs(id, 0);
        System.out.println(answer);

    }
}
