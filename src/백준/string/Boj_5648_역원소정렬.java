package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_5648_역원소정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Long> nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        if(!st.hasMoreElements()) return; //아무것도 없는 경우
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            StringBuilder reverse = new StringBuilder(st.nextToken()).reverse();
            nums.add(Long.parseLong(reverse.toString()));
        }

        Collections.sort(nums);

        for (long num : nums) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
