package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2693_N번쨰큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            List<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);
            sb.append(arr.get(7)).append("\n");
        }
        System.out.println(sb);
    }
}
