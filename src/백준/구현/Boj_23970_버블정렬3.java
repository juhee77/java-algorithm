package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_23970_버블정렬3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arrStart = new int[n];
        int[] arrEnd = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrStart[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrEnd[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(contain(n, arrStart, arrEnd) ? 1 : 0);

    }

    private static boolean contain(int n, int[] arrStart, int[] arrEnd) {
        if (isSame(arrStart, arrEnd))
            return true;
        for (int i = n-1; 0<=i; i--) {
            for (int j = 0; j<i; j++) {
                if (arrStart[j] > arrStart[j + 1]) {
                    int temp = arrStart[j];
                    arrStart[j] = arrStart[j + 1];
                    arrStart[j + 1] = temp;

//                    System.out.println(Arrays.toString(arrStart));
                    if (isSame(arrStart, arrEnd)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isSame(int[] arrStart, int[] arrEnd) {
        for (int i = 0; i < arrStart.length; i++) {
            if (arrStart[i] != arrEnd[i]) {
                return false;
            }
        }
        return true;
    }
}
