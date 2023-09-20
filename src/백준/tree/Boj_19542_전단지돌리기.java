package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_19542_전단지돌리기 {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int nodeCnt, power,start;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken()) - 1; // 시작위치
        power = Integer.parseInt(st.nextToken()); //전파 방향

        for (int i = 0; i < nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        solution(start, 0);
        System.out.println(ans * 2);
    }

    private static int solution(int now, int prev) {
        int max = 0;
        for (Integer child : graph.get(now)) { //현재 나의 자식들 (레벨이 level)
            if (child != prev)
                max = Math.max(max, solution(child, now) + 1);
        }
        if (now != start && max >= power) {
            ans++;
        }
        return max;
    }

}
