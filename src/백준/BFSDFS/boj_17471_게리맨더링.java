package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17471_게리맨더링 {
    private static final List<List<Integer>> Graph = new LinkedList<>();
    private static int city;
    private static int[] people;
    private static int min = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        city = Integer.parseInt(br.readLine());
        for (int i = 0; i < city; i++) {
            Graph.add(new LinkedList<>());
        }
        people = new int[city];
        visited = new boolean[city];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int nearCount = Integer.parseInt(temp.nextToken());
            while (nearCount-- > 0) {
                Graph.get(i).add(Integer.parseInt(temp.nextToken()) - 1);
            }
        }

        visited[0] = true;
        backtracking(0);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void backtracking(int now) {
        //부모노드를 찾아야 한다, 연결되어있는지 확인
        //visit 되지 않은것중에 확인O
        if (now == city) {
            List<Integer> cityA = new LinkedList<>();
            List<Integer> cityB = new LinkedList<>();
            for (int i = 0; i < city; i++) {
                if (!visited[i]) {
                    cityA.add(i);
                } else {
                    cityB.add(i);
                }
            }

            if (dfs(cityA) && dfs(cityB)) {
                //System.out.println(cityA+"  "+cityB);
                int diff = findDiff();
                if (diff < min) min = diff;
            }
            return;
        }

        visited[now] = true;
        backtracking(now + 1);

        visited[now] = false;
        backtracking(now + 1);
    }

    private static int findDiff() {
        int sum = 0;
        for (int i = 0; i < city; i++) {
            if (visited[i]) {
                sum += people[i];
            } else {
                sum -= people[i];
            }
        }
        return Math.abs(sum);
    }

    private static boolean dfs(List<Integer> nowCity) {
        if (nowCity.size() <= 0) return false;

        boolean[] dfsVisited = new boolean[city];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nowCity.get(0));
        dfsVisited[nowCity.get(0)] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int e : Graph.get(now)) {
                if (nowCity.contains(e) && !dfsVisited[e]) {
                    dfsVisited[e] = true;
                    queue.add(e);
                }
            }
        }

        //System.out.println("dfsVisited = " + Arrays.toString(dfsVisited));
        for (int e : nowCity) {
            if (!dfsVisited[e]) {
                return false;
            }
        }
        return true;

    }
}
