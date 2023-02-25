package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17471_게리맨더링2 {
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
        findMin(0);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void findMin(int now) {
        //부모노드를 찾아야 한다, 연결되어있는지 확인
        //visit 되지 않은것중에 확인O
        if (now == city) {
            if (checkingSubset()) {
                //System.out.println(cityA+"  "+cityB);
                int diff = findDiff();
                if (diff < min) min = diff;
            }
            return;
        }

        visited[now] = true;
        findMin(now + 1);

        visited[now] = false;
        findMin(now + 1);
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

    private static boolean checkingSubset() {
        boolean[] dfsVisitedA = new boolean[city];
        boolean[] dfsVisitedB = new boolean[city];

        for (int i = 0; i < city; i++) {
            if (visited[i]) {
                for (int e : Graph.get(i)) {
                    dfsVisitedA[e] = true;
                }
            } else {
                for (int e : Graph.get(i)) {
                    dfsVisitedB[e] = true;
                }
            }
        }

        //System.out.println("dfsVisited = " + Arrays.toString(dfsVisited));
        for (int i = 0; i < city; i++) {
            if (visited[i]&& !dfsVisitedA[i]) return false;
            else if (!visited[i]&&!dfsVisitedB[i]) return false;

        }

        return true;

    }
}
