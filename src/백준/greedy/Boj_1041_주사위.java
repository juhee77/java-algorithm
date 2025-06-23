package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1041_주사위 {
    private static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dice = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dictDimension1 = new int[][]{{0}, {1}, {2}, {3}, {4}, {5}};
        int[][] dictDimension2 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
        int[][] dictDimension3 = new int[][]{{0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4}, {1, 2, 5}, {1, 3, 5}, {2, 4, 5}, {3, 4, 5}};
        List<Integer> dimension3 = getSumList(dictDimension3);
        List<Integer> dimension2 = getSumList(dictDimension2);
        List<Integer> dimension1 = getSumList(dictDimension1);

//        System.out.println("minDimension3 = " + (int) dimension3.get(0));
//        System.out.println("minDimension2 = " + (int) dimension2.get(0));
//        System.out.println("minDimension1 = " + (int) dimension1.get(0));

        long sum = 0;
        if (n == 1) {
            for (int i = 0; i < 5; i++) {
                sum += dimension1.get(i);
            }
        } else {
            sum += dimension3.get(0) * 4;
            sum += dimension2.get(0) * (8L * n - 12);
            sum += (long) (dimension1.get(0) * (5 * Math.pow(n - 2, 2) + 4L * (n - 2)));
        }
        System.out.println(sum);


    }

    private static List<Integer> getSumList(int[][] dictDimension) {
        List<Integer> sumList = new ArrayList<>();
        for (int[] ints : dictDimension) {
            int sum = 0;
            for (int anInt : ints) {
                sum += dice[anInt];
            }
            sumList.add(sum);
        }
        Collections.sort(sumList);
        return sumList;
    }
}
