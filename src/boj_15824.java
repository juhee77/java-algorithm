import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15824 {
    //스코빌 지수 -> 절대적
    // 주헌이는 상대수치에 기반한다.
    // 스코빌 지수가 있을때 최댓값과 최솟값차이를 주헌 고통 지수라고 정의한다.
    //이 음식점의 모든 조합을 먹어보는것

    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long[] pow = new long[size + 1];
        long now = 1;
        long sum = 0;
        pow[0] = 0;
        for (int i = 1; i <= size; i++) {
            pow[i] = (pow[i - 1] + now) % MOD;
            now = (now * 2) % MOD;
        }


        for (int i = 0; i < size; i++) {
            long temp = (arr[i] * (pow[i] - pow[size - i - 1] + MOD) % MOD) % MOD;
            sum = (sum + temp + MOD) % MOD;
        }
        System.out.println(sum);

    }
}