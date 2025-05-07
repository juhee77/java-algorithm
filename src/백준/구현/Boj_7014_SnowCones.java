package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7014_SnowCones {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            char[] input = br.readLine().toCharArray();
            char[] output = br.readLine().toCharArray();

            int[] leftO = new int[input.length];
            int[] rightO = new int[input.length];
            int[] leftX = new int[input.length];
            int[] rightX = new int[input.length];

            left(input, 'O', leftO);
            left(input, 'X', leftX);

            right(input, 'O', rightO);
            right(input, 'X', rightX);

//            System.out.println(Arrays.toString(leftO) + Arrays.toString(rightO) + Arrays.toString(leftX) + Arrays.toString(rightX));
            sb.append("Data Set " + i + ":" + "\n");
            int left = findMinMax(leftO, 'O', rightO, output);
            int right = findMinMax(leftX, 'X', rightX, output);
//            System.out.println(left + "," + right);
            sb.append(Math.max(left, right)).append("\n");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findMinMax(int[] leftO, char hold, int[] rightO, char[] goal) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < leftO.length; i++) {
            if (goal[i] == hold)
                min = Math.max(leftO[i], rightO[i]);
        }
        return min;
    }

    private static void left(char[] input, char hold, int[] leftO) {
        int leftIdx = Integer.MAX_VALUE;
        for (int j = 0; j < input.length; j++) {
            if (input[j] == hold)
                leftIdx = j;
            if (leftIdx == Integer.MAX_VALUE)
                leftO[j] = 0;
            else
                leftO[j] = j - leftIdx;
        }
    }

    private static void right(char[] input, char hold, int[] rightO) {
        int rightIdx = Integer.MAX_VALUE;
        for (int j = input.length - 1; 0 <= j; j--) {
            if (input[j] == hold)
                rightIdx = j;

            if (rightIdx == Integer.MAX_VALUE)
                rightO[j] = 0;
            else
                rightO[j] = rightIdx - j;
        }
    }
}
