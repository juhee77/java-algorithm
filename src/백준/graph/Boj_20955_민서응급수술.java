package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20955_민서응급수술 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int nureon = Integer.parseInt(st.nextToken());
        int synaps = Integer.parseInt(st.nextToken());

        parents = new int[nureon];
        for (int i = 0; i < nureon; i++) {
            parents[i] = i;
        }
        int cnt = 0;

        while (synaps-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;

            n1 = findParents(n1);
            n2 = findParents(n2);
            if (n1 != n2) {
                union(n1, n2);
            } else
                cnt++;//끊어내기
        }

        for (int i = 0; i < nureon; i++) {
            if (parents[i] == i) {
                cnt++;
            }
        }

        System.out.println(cnt - 1);
    }


    private static void union(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static int findParents(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParents(parents[x]);
    }
}
