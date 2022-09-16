package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_17219_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int save = Integer.parseInt(st.nextToken());
        int want = Integer.parseInt(st.nextToken());
        HashMap<String, String> hash = new HashMap<>();

        for (int i = 0; i < save; i++) {
            st = new StringTokenizer(br.readLine());
            hash.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < want; i++)
            sb.append(hash.get(br.readLine())).append('\n');

        System.out.println(sb);

    }
}
