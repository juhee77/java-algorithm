package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1765_닭싸움팀정하기 {
    private static int[] parents;
    private static final List<List<Integer>> emptyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int peopleNum = Integer.parseInt(br.readLine());
        parents = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            emptyList.add(new ArrayList<>());
        }

        for (int i = 0; i < peopleNum; i++) {
            parents[i] = i;
        }

        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (command == 'E') {
                emptyList.get(a).add(b);
                emptyList.get(b).add(a);
            } else {
                //두 개를 합친다.
                union(a, b);
            }
        }


        for (List<Integer> integers : emptyList) {
            if (integers.size() >= 2) {
                //적의 적은 나의 친구이므로 적들끼리의 값을 모두 갱신 한다
                int minParents = Integer.MAX_VALUE;
                for (Integer integer : integers) {
                    minParents = Math.min(minParents, findParent(integer));
                }

                for (Integer integer : integers) {
                    parents[integer] = minParents;
                }
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int parent : parents) {
            hashSet.add(findParent(parent));
        }
        System.out.println(hashSet.size());
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static int findParent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }
}
