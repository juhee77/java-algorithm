package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_13418_학교탐방하기 {
    private static class Road {
        int start;
        int end;

        public Road(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1; //city
        int m = Integer.parseInt(st.nextToken()) + 1;

        List<Road> slopes = new ArrayList<>(); //경사로들만
        List<Road> descs = new ArrayList<>(); //내리막길말


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int slope = Integer.parseInt(st.nextToken());
            if (slope == 0) {
                slopes.add(new Road(start, end));
            } else {
                descs.add(new Road(start, end));
            }
        }
        parents = new int[n];

        //경사로 연결할 수 있는 만큼 연결하는 경우
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int maxCnt = 0;
        for (Road slope : slopes) {
            if (union(slope.start, slope.end)) {
                maxCnt++;
            }
        }

        //내려가는 길을 연결할 수 있는 만큼 연결하는 경우
        int minCnt= n-1;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (Road desc : descs) {
            if(union(desc.start, desc.end)){
                minCnt--;
            }
        }

        System.out.println((maxCnt * maxCnt) - (minCnt * minCnt));
    }

    private static boolean union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a != b) {
            if (a < b) parents[b] = a;
            else parents[a] = b;
            return true;
        }
        return false;
    }

    private static int findParent(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findParent(parents[a]);
    }
}
