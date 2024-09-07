package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15688_수정렬하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        while (n-- > 0) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        for (Integer integer : arr) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
    }
}
