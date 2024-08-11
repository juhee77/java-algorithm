package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10972_다음순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(n, ans)) {
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation(int n, int[] ans) {
        int left = ans.length - 1;
        while (left > 0 && ans[left - 1] >= ans[left]) {
            left--;
        }

        if (left == 0) return false;

        int right = ans.length - 1;
        while (ans[right] <= ans[left - 1]) {
            right--;
        }

        swap(ans, left - 1, right);
        reverse(ans, left, n - 1);
        return true;
    }


    private static void reverse(int[] ans, int left, int right) {
        while (left < right) {
            swap(ans, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] ans, int i, int j) {
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }

}
