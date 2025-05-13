package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_18110_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(scores);

        int threshold = (int) Math.round((double) n * 0.15);
        double sum = 0;
        for (int i = threshold; i < scores.size() - threshold; i++) {
            sum += scores.get(i);
        }

        System.out.println(Math.round(sum / (scores.size() - threshold * 2)));
    }
}
