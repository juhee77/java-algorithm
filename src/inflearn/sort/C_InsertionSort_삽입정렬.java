package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_InsertionSort_삽입정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr));
        System.out.println(Arrays.toString(solution2(n, arr)));
    }

    private static String solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j;
            for (j = i - 1; 0 <= j; j--) {
                if (arr[j] < temp) break;
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp; //삽입 정렬 느낌이 나도록 계산하기
        }
        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j).append(" ");
        }
        return sb.toString();
    }

    public static int[] solution2(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}
