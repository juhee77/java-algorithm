package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1083_소트_sort {
    private static final List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        /*input*/
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int chance = Integer.parseInt(br.readLine());
        dfsSort(chance, 0);
        StringBuilder sb = new StringBuilder();
        for (int e : arr) sb.append(e).append(" ");
        System.out.println(sb);
    }

    private static void dfsSort(int chance, int start) {
        if (chance <= 0 || arr.size() <= start) return;

        int tempMaxIdx = start;
        int tempMax = arr.get(start);
        for (int i = start + 1; i < Math.min(arr.size(), start + chance + 1); i++) {
            if (tempMax < arr.get(i)) {
                tempMax = arr.get(i);
                tempMaxIdx = i;
            }
        }

        if (tempMaxIdx == start) { //0~chance에서는 정렬할게 없음
            dfsSort(chance, start + 1);
        } else {
            arr.remove(tempMaxIdx);
            arr.add(start, tempMax);
            dfsSort(chance - (tempMaxIdx - start), start + 1);
        }
    }
}
