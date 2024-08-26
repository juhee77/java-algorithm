package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_11931_수정렬하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0)
            arr.add(Integer.parseInt(br.readLine()));

        arr.sort(Collections.reverseOrder());

        for (Integer integer : arr)
            sb.append(integer).append("\n");
        System.out.println(sb);
    }
}
