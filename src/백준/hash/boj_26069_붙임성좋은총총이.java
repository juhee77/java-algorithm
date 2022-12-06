package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_26069_붙임성좋은총총이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashSet<String> map = new HashSet<>();
        map.add("ChongChong");
        int line = Integer.parseInt(br.readLine());

        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            if (!map.contains(first) || !map.contains(second)) {
                if(map.contains(first)){
                    map.add(second);
                }
                else if(map.contains(second)){
                    map.add(first);
                }
            }

        }
        System.out.println(map.size());
    }
}
