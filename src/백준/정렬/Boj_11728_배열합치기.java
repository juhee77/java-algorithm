package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            arr.add(Integer.parseInt(st.nextToken()));

        Collections.sort(arr);
        for (Integer temp : arr)
            sb.append(temp).append(" ");
        System.out.println(sb);
    }
}
