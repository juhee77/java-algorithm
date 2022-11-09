package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class boj_2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int point = 0;
        while (sb.length() < N - K) {
            int max = arr[point];
            int maxIdx = point;
            //일단 최댓값 찾기(뒤에를 나머지 채워야 할 수로 남겨두고)
            for (int i = point; i <= K + sb.length(); i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    maxIdx = i;
                }
                if (max == 9) break;
            }
            sb.append(max);
            point = maxIdx + 1;
        }
        System.out.println(sb);

    }
}