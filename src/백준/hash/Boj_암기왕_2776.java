package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_암기왕_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        HashSet<Integer> memory = new HashSet<>();
        while (tc-- > 0) {
            memory.clear();
            int col = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (col-- > 0) {
                memory.add(Integer.parseInt(st.nextToken()));
            }

            int ans = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (ans-- > 0) {
                sb.append(memory.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
