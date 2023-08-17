package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10216_CountCircleGroups {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int[][] arr;
        while (tc-- > 0) {
            int line = Integer.parseInt(br.readLine());
            int cnt = line;
            arr = new int[line][3];
            parents = new int[line];
            for (int i = 0; i < line; i++) {
                parents[i] = i;
            }

            //일단 처음것 하나를 받는다
            st = new StringTokenizer(br.readLine());
            arr[0][0] = Integer.parseInt(st.nextToken());
            arr[0][1] = Integer.parseInt(st.nextToken());
            arr[0][2] = Integer.parseInt(st.nextToken());


            for (int i = 1; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());

                for (int j = 0; j < i; j++) {
                    if (isSameAge(arr[j], arr[i])){
                        if(unionParents(i, j)){
                            cnt--;
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isSameAge(int[] circle1, int[] circle2) {
        int dy = circle1[1] - circle2[1];
        int dx = circle1[0] - circle2[0];
        int dr = circle1[2] + circle2[2];
        return (dy*dy) + (dx*dx) <= (dr*dr);

    }

    private static boolean unionParents(int a, int b) {
        a = findParents(a);
        b = findParents(b);
        if (a != b) {
            if (a < b) parents[b] = a;
            else parents[a] = b;

            return true;
        }
        return false;
    }

    private static int findParents(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findParents(parents[a]);
    }
}