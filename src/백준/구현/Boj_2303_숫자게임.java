package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2303_숫자게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int index = 0;

        for (int j = 1; j <= n; j++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            int temp = (arr.get(0) + arr.get(1) + arr.get(2)) % 10;
            temp = Math.max((arr.get(0) + arr.get(1) + arr.get(2)) % 10, temp);
            temp = Math.max((arr.get(0) + arr.get(1) + arr.get(3)) % 10, temp);
            temp = Math.max((arr.get(0) + arr.get(1) + arr.get(4)) % 10, temp);
            temp = Math.max((arr.get(0) + arr.get(2) + arr.get(3)) % 10, temp);
            temp = Math.max((arr.get(0) + arr.get(2) + arr.get(4)) % 10, temp);
            temp = Math.max((arr.get(0) + arr.get(3) + arr.get(4)) % 10, temp);
            temp = Math.max((arr.get(1) + arr.get(2) + arr.get(3)) % 10, temp);
            temp = Math.max((arr.get(1) + arr.get(2) + arr.get(4)) % 10, temp);
            temp = Math.max((arr.get(1) + arr.get(3) + arr.get(4)) % 10, temp);
            temp = Math.max((arr.get(2) + arr.get(3) + arr.get(4)) % 10, temp);

            if (max <= temp) {
                index = j;
                max = temp;
            }

        }
        System.out.println(index);

    }
}
