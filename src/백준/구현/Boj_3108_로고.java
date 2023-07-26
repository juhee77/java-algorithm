package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_3108_로고 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
            map[i][3] = Integer.parseInt(st.nextToken());
        }

        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i <= n; i++) {
            int pointXStart = Math.min(map[i][0], map[i][2]);
            int pointXEnd = Math.max(map[i][0], map[i][2]);
            int pointYStart = Math.min(map[i][1], map[i][3]);
            int pointYEnd = Math.max(map[i][1], map[i][3]);

            for (int j = i + 1; j <= n; j++) {
                int innerXStart = Math.min(map[j][0], map[j][2]);
                int innerXEnd = Math.max(map[j][0], map[j][2]);
                int innerYStart = Math.min(map[j][1], map[j][3]);
                int innerYEnd = Math.max(map[j][1], map[j][3]);

                if (check(pointXStart, pointXEnd, pointYStart, pointYEnd, innerXStart, innerXEnd, innerYStart, innerYEnd)) {
                    unionFind(i, j);
                }
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            hashSet.add(findParents(i));
        }
        System.out.println(hashSet.size() - 1);
    }

    private static boolean check(int pointXStart, int pointXEnd, int pointYStart, int pointYEnd, int innerXStart, int innerXEnd, int innerYStart, int innerYEnd) {

        //포함 되는 경우는 제외
        if (pointXStart > innerXStart && pointXEnd < innerXEnd
                && pointYStart > innerYStart && pointYEnd < innerYEnd) {
            return false;
        }
        if (pointXStart < innerXStart && pointXEnd > innerXEnd
                && pointYStart < innerYStart && pointYEnd > innerYEnd) {
            return false;
        }


        if (pointXStart > innerXEnd) return false;
        if (pointXEnd < innerXStart) return false;
        if (pointYStart > innerYEnd) return false;
        if (pointYEnd < innerYStart) return false;

        return true;
    }

    private static int findParents(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = findParents(parents[a]);
    }

    private static void unionFind(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a == b) return;

        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

}
