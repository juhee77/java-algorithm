package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class F_중복확인 {
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
        System.out.println(solution2(n, arr));
    }

    private static String solution(int[] arr) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i : arr) {
            if (hash.contains(i)) return "D";
            hash.add(i);
        }
        return "U";
    }

    public static String solution2(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr); //정렬 자체가 nlogn이다.
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = "D";
                break;
            }
        }
        return answer;
    }
}
