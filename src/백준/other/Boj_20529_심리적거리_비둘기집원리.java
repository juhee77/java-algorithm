package 백준.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_20529_심리적거리_비둘기집원리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int humanCnt = Integer.parseInt(br.readLine());
            String[] mbtis = br.readLine().split(" ");

            if(humanCnt>32){
                sb.append(0 + "\n"); //mbit 16개가 겹치지 않게 나와도 33개 부터는 최소한 세번은 겹쳐서 나온다.
                continue;
            }

            int[][] map = new int[humanCnt][humanCnt];
            int point = Integer.MAX_VALUE;
            for (int i = 0; i < humanCnt; i++) {
                for (int j = i + 1; j < humanCnt; j++) {
                    map[i][j] = getDiff(mbtis[i], mbtis[j]);
                }
            }

            for (int i = 0; i < humanCnt - 2; i++) {
                for (int j = i + 1; j < humanCnt - 1; j++) {
                    for (int k = j + 1; k < humanCnt; k++) {
                        point = Math.min(point, map[i][j] + map[j][k] + map[i][k]);
                    }
                }
            }
            sb.append(point).append("\n");
        }
        System.out.println(sb);
    }


    private static int getDiff(String a, String b) {
        int point = 0;
        for (int p = 0; p < 4; p++) {
            if (a.charAt(p) != b.charAt(p)) {
                point++;
            }
        }
        return point;
    }
}
