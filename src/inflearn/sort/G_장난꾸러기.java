package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G_장난꾸러기 {
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
        StringBuilder sb = new StringBuilder();
        int[] students = arr.clone();
        Arrays.sort(students);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != students[i]) {
                sb.append(i + 1).append(" ");
            }
        }
        return sb.toString();
    }

    public static ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) answer.add(i + 1);
        }
        return answer;
    }
}
