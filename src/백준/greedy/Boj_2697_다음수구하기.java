package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2697_다음수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            char[] arr = s.toCharArray();

            if (nextPermutation(arr)) {
                sb.append(new String(arr)).append("\n");
            } else {
                sb.append("BIGGEST").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i == -1) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int left = i + 1, right = arr.length - 1;
        while (left < right) {
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }

        return true;
    }
}
