package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] input = br.readLine().toCharArray();
            sb.append(checkPalindrome(input)).append("\n");
        }
        System.out.println(sb);
    }

    public static int checkPalindrome(char[] input) {
        int left = 0, right = input.length - 1;

        while (left < right) {
            if (input[left] != input[right]) {
                // 하나 빠구고 나서 나머지가 회문인지 확인
                if (isPalindrome(input, left + 1, right) || isPalindrome(input, left, right - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
            left++;
            right--;
        }
        return 0;
    }

    public static boolean isPalindrome(char[] input, int left, int right) {
        while (left < right) {
            if (input[left] != input[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
