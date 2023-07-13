package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16964_DFS스페셜저지 {
    private static List<HashSet<Integer>> map;
    private static int[] target;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            map.add(new HashSet<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            map.get(left).add(right);
            map.get(right).add(left);
        }

        target = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            target[i + 1] = Integer.parseInt(st.nextToken());
        }

        if (target[1] != 1) System.out.println(0);
        else System.out.println(check(target[1], 2) == Integer.MAX_VALUE ? 1 : 0);
    }

    private static int check(int now, int depth) {
        if (depth == n + 1) {
            return Integer.MAX_VALUE;
        }

//        System.out.println(now + " " + depth + " " + target[depth]);

        while (depth != Integer.MAX_VALUE && map.get(now).contains(target[depth])) {
            map.get(now).remove(target[depth]);
            depth = check(target[depth], depth + 1);
//            System.out.println("BACK"+depth);
        }
        return depth;
    }
}
