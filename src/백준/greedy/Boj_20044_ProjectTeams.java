package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_20044_ProjectTeams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int total = n * 2;
        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr.get(i) + arr.get(total - 1 - i));
        }
        System.out.println(min);
    }
}
