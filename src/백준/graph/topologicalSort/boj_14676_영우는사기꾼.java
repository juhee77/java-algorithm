package 백준.graph.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class boj_14676_영우는사기꾼 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final List<List<Integer>> outGraph = new ArrayList<>();
    private static int[] inDegree;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//건물 종류 갯수
        int m = Integer.parseInt(st.nextToken());//건물 사이 관계의 개수
        k = Integer.parseInt(st.nextToken()); //게임 정보의 개수

        for (int i = 0; i < n; i++) {
            outGraph.add(new ArrayList<>());
        }
        inDegree = new int[n];

        //x를 건설해야 y를 건설 할 수 있음
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            outGraph.get(x).add(y);
            inDegree[y]++;
        }
        System.out.println(checkLier() ? "Lier!" : "King-God-Emperor");
    }

    private static boolean checkLier() throws IOException {
        int[] buildings = new int[n];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken()) - 1;

            if (cmd == 1) {
                if (inDegree[index] != 0) {//건물을 지울 수 있는가
                    return true;
                }

                buildings[index]++;
                if (buildings[index] == 1) { //건물이 하나만 지어진 경우에는
                    for (Integer next : outGraph.get(index)) {
                        inDegree[next]--;
                    }
                }
            } else {
                if (buildings[index] == 0) return true; //지어지지 않은 건물은 부시려고 함
                if (buildings[index] == 1) { //건물이 하나만 있는 경우는 다음 조건들을 ++
                    for (Integer next : outGraph.get(index)) {
                        inDegree[next]++;
                    }
                }
                buildings[index]--; //건물을 부신다.

            }
        }
        return false;
    }
}
