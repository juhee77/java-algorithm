package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1976_여행가자 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int city = Integer.parseInt(br.readLine());
        parents = new int[city];
        for (int i = 0; i < city; i++) {
            parents[i] = i;
        }

        int line = Integer.parseInt(br.readLine());

        for(int start=0;start<city;start++) {
            st = new StringTokenizer(br.readLine());
            for (int end = 0; end < city; end++) {
                int isLinked = Integer.parseInt(st.nextToken());
                if (isLinked == 1) {
                    unionParent(start, end);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> cities = new ArrayList<>();
        while (line-->0) {
            cities.add(Integer.parseInt(st.nextToken()) - 1);
        }

        if (check(cities)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean check(List<Integer> cities) {
        Collections.sort(cities);
        int min = cities.get(0);
        for (int city : cities) {
            if (min != findParent(city)) {
                return false;
            }
        }
        return true;
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else {
            parents[a] = b;
        }
    }

    private static int findParent(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findParent(parents[x]);
    }
}
