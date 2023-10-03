package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14921_용액합성하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int left = 0, right = n - 1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int twoDiff = arr.get(left) + arr.get(right);
            if (Math.abs(twoDiff) <= Math.abs(min)) {
                min = twoDiff;
            }

            if (twoDiff >= 0) right--;
            else left++;
        }
        System.out.println(min);

    }

}
