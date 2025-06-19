package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_30804_과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> color = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
        }

        int lastIndex = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            color.put(arr[i], color.getOrDefault(arr[i], 0) + 1);
            while (color.size() > 2) {
                color.put(arr[lastIndex], color.get(arr[lastIndex]) - 1);
                if (color.get(arr[lastIndex]) == 0) {
                    color.remove(arr[lastIndex]);
                }
                lastIndex++;
            }

            max = Math.max(max, i - lastIndex + 1);
        }

        System.out.println(max);
    }
}
