package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9613_GCD의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {

            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            long sum = 0;
            int[] arr = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < cnt - 1; j++) {
                for (int p = j + 1; p < cnt; p++) {
                    sum += gcd(arr[j], arr[p]);
                }
            }
            System.out.println(sum);

        }
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}
