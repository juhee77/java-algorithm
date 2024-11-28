package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_21940_가운데서만나기 {

    public static final int INF = (int) 1e6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int arr[][] = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        int line = Integer.parseInt(st.nextToken());
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start][end] = cost;
        }

        for (int k = 1; k < size + 1; k++) {
            for (int i = 1; i < size + 1; i++) {
                for (int j = 1; j < size + 1; j++) {
                    int cost = arr[i][k] + arr[k][j];
                    if (arr[i][j] > cost)
                        arr[i][j] = cost;
                }
            }
        }

        int friendsCnt = Integer.parseInt(br.readLine());
        List<Integer> friends = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (friendsCnt-- > 0)
            friends.add(Integer.parseInt(st.nextToken()));

        int minCost = Integer.MAX_VALUE;
        List<Integer> minCities = new ArrayList<>();
        for (int middleCity = 1; middleCity <= size; middleCity++) {
            int maxAroundCost = getMaxAroundCost(arr, friends, middleCity, 0);

            if (maxAroundCost == -1) continue;
            if (maxAroundCost < minCost) {
                minCost = maxAroundCost;
                minCities.clear();
                minCities.add(middleCity);
            } else if (minCost == maxAroundCost) {
                minCities.add(middleCity);
            }

//            System.out.println(middleCity + " " + maxAroundCost + " " + minCost + " " + minCities);
        }

        for (Integer minCity : minCities)
            sb.append(minCity).append(" ");
        System.out.println(sb);
    }

    private static int getMaxAroundCost(int[][] arr, List<Integer> friends, int middleCity, int maxAroundCost) {
        for (Integer friend : friends)
            if (arr[friend][middleCity] != INF && arr[middleCity][friend] != INF)
                maxAroundCost = Math.max(maxAroundCost, arr[friend][middleCity] + arr[middleCity][friend]);
            else return -1;
        return maxAroundCost;
    }
}
