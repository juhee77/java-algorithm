package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18869_멀티버스2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int galaxyCnt = Integer.parseInt(st.nextToken());//우주의 개수
        int planetCnt = Integer.parseInt(st.nextToken());//우주 행성의 수

        int[] map = new int[planetCnt];
        int[][] ranks = new int[galaxyCnt][planetCnt];

        List<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> sortedHash = new HashMap<>();
        int rank, cnt = 0;

        for (int i = 0; i < galaxyCnt; i++) {
            st = new StringTokenizer(br.readLine());
            sorted.clear();
            sortedHash.clear();

            for (int j = 0; j < planetCnt; j++) {
                map[j] = Integer.parseInt(st.nextToken());
                sorted.add(map[j]);
            }
            Collections.sort(sorted);

            rank = 1;
            for (int j = 0; j < planetCnt; j++) {
                if (!sortedHash.containsKey(sorted.get(j)))
                    sortedHash.put(sorted.get(j), rank++);
            }

            for (int j = 0; j < planetCnt; j++) {
                ranks[i][j] = sortedHash.get(map[j]);
            }

            //자신보다 앞에 있는 우주들중에 평행한것이 있다면 추가한다.
            for (int p = 0; p < i; p++) {
                if (check(ranks[i], ranks[p])) {
                    cnt++;
                }
            }
        }


        System.out.println(cnt);
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

}
