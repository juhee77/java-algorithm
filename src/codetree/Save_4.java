package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Save_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            set.put(temp, set.getOrDefault(temp, 0) + 1);
        }
//        System.out.println(set);

        List<Integer> arr = new ArrayList<>(set.keySet());
        Collections.sort(arr);
        n = arr.size();
        int left = 0, right = 0;
        int ans = 0;
        while (left <= right && right < n) {
            int diff = arr.get(right) - arr.get(left);
            if (diff == k) {
                if (diff == 0) {
                    Integer now = set.get(arr.get(right));
                    ans += now * (now - 1) / 2;
                } else ans += set.get(arr.get(right)) * set.get(arr.get(left));
                left++;
                right++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
        System.out.println(ans);

    }
}