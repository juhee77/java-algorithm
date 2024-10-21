package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2012_등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);

        long dissatisfaction = 0;
        for (int i = 0; i < n; i++) {
            int actualRank = i + 1;
            dissatisfaction += Math.abs(arr.get(i) - actualRank);
        }
        System.out.println(dissatisfaction);
    }
}
