package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        while (line-- > 0) {
            String now = br.readLine();
            if (hashSet.contains(now)) {
                hashSet.remove(now);
            }
            hashSet.add(now);
        }

        Iterator<String> iterator = hashSet.iterator();
        for (int i = 0; i < size&&iterator.hasNext(); i++) {
            sb.append(iterator.next()).append("\n");
        }

        System.out.println(sb);
    }
}
