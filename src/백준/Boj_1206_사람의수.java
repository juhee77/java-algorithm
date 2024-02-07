package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj_1206_사람의수 {
    private static double[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        int ans = 0;
        for (int i = 1; i < 1000; i++) {
            if (able(i)) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    private static boolean able(int goal) {
        for (int i = 0; i < n; i++) {
            double ans = arr[i] * goal;
            System.out.println((arr[i] * goal * 1000) + " " + i + " " + ans);

            if (1000 - ans > 9 && 1000 - ans != 1000)
                return false;

        }
        return true;
    }
}
