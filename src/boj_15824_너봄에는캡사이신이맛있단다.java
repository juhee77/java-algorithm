import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15824_너봄에는캡사이신이맛있단다 {
    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        long[] pow = new long[size + 1];
        pow[0] = 0;

        long now = 1;
        for (int i = 1; i <= size; i++) {
            pow[i] = (pow[i - 1] + now % MOD) % MOD;
            now = (now * 2) % MOD;
        }

        long sum = 0;
        for (int i = 0; i < size; i++) {
            long temp = (input[i] * (pow[i] - pow[size - i - 1] + MOD) % MOD) % MOD;
            sum = (sum + temp + MOD) % MOD;
        }
        System.out.println(sum);

    }
}
