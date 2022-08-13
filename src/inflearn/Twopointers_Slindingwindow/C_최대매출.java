package inflearn.Twopointers_Slindingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C_최대매출 {
    public int solution(int n, int k, int[] arr) {
        int answer, sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        int max = 0;
        for (int i = 0; i < goal; i++) max += arr[i];
        int sum = max;


        for (int i = goal; i < num; i++) {
            sum += arr[i] - arr[i - goal];
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }
}
