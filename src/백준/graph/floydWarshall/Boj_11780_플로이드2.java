package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11780_플로이드2 {

    public static final int MAX = (int) 1e8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int city = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        int[][] dMap = new int[city][city];
        List<Integer>[][] cities = new ArrayList[city][city];
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                cities[i][j] = new ArrayList<>();
                if (i != j) {
                    cities[i][j].add(i + 1);
                    cities[i][j].add(j + 1);
                }
            }
        }

        for (int i = 0; i < city; i++) {
            Arrays.fill(dMap[i], MAX);
            dMap[i][i] = 0;
        }

        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dMap[a - 1][b - 1] = Math.min(c, dMap[a - 1][b - 1]);
        }


        for (int i = 0; i < city; i++) {
            for (int p = 0; p < city; p++) {
                for (int q = 0; q < city; q++) {
                    if (dMap[p][q] > dMap[p][i] + dMap[i][q]) {
                        dMap[p][q] = dMap[p][i] + dMap[i][q];

                        ArrayList<Integer> temp = new ArrayList<>(cities[p][i]);
                        temp.remove(temp.size() - 1);
                        temp.addAll(cities[i][q]);
                        cities[p][q] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (dMap[i][j] == MAX) {
                    sb.append(0).append(" ");
                } else sb.append(dMap[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (dMap[i][j] != MAX) {
                    sb.append(cities[i][j].size()).append(" ");
                    for (Integer integer : cities[i][j]) {
                        sb.append(integer).append(" ");
                    }
                } else sb.append("0");
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
