package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1026_보물 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int size;

    public static void main(String[] args) throws IOException {

        size = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        scanInput(list);
        scanInput(list2);

        Collections.sort(list);
        list2.sort(Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < size; i++)
            ans += list.get(i) * list2.get(i);

        System.out.println(ans);
    }

    private static void scanInput(List<Integer> list) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) list.add(Integer.parseInt(st.nextToken()));
    }
}
