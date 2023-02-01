package inflearn.dfs_bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class O_피자배달거리 {
    private static int remain;
    private static int min;
    private static int[] selectedPizzas;
    private static final List<Point> pizzas = new ArrayList<>();
    private static final List<Point> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        remain = Integer.parseInt(st.nextToken());

        int[][] map = new int[size][size];
        selectedPizzas = new int[remain];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) pizzas.add(new Point(i, j));
                else if (map[i][j] == 1) houses.add(new Point(i, j));
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int start, int nowDepth) {
        if (nowDepth == remain) {
            //System.out.println(Arrays.toString(arr));
            min = Math.min(min, calculateDistance());
            return;
        }
        for (int i = start; i < pizzas.size(); i++) {
            selectedPizzas[nowDepth] = i;
            dfs(i + 1, nowDepth + 1);
        }

    }

    private static int calculateDistance() {
        int sum = 0;
        for (Point nowHouse : houses) {
            int min = Integer.MAX_VALUE;
            for (int selectedPizza : selectedPizzas) {
                Point nowPizza = pizzas.get(selectedPizza);
                min = Math.min(min, Math.abs(nowHouse.x - nowPizza.x) + Math.abs(nowHouse.y - nowPizza.y));
            }
            sum += min;
        }
        return sum;
    }

    private static int check() {
        int[] houseToPizza = new int[houses.size()];
        Arrays.fill(houseToPizza, Integer.MAX_VALUE);
        for (int selectedPizza : selectedPizzas) {
            Point nowPizza = pizzas.get(selectedPizza);

            for (int i = 0; i < houses.size(); i++) {
                Point nowHouse = houses.get(i);
                houseToPizza[i] = Math.min(houseToPizza[i], Math.abs(nowHouse.x - nowPizza.x) + Math.abs(nowHouse.y - nowPizza.y));
            }
        }
        //System.out.println(Arrays.toString(houseToPizza));
        return Arrays.stream(houseToPizza).sum();
    }


}
