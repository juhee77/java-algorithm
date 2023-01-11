package contest.보라매컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());

        int cnt = 0;
        HashSet<Integer> hash = new HashSet<>();
        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //들어감
            if (b == 1) {
                if (hash.contains(a)) {
                    cnt++;
                }
                else hash.add(a);
            } else if (b == 0) {
                if (!hash.contains(a)) {
                    cnt++;
                }
                else hash.remove(a);
            }
        }

        System.out.println(cnt+hash.size());

    }
}
