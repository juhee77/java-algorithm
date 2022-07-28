package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        HashSet<Integer> hash = new HashSet<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<line;i++){
            hash.add(Integer.parseInt(st.nextToken()));
        }

        line = Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine());

        for(int i=0;i<line;i++){
            int temp = Integer.parseInt(st.nextToken());

            if(hash.contains(temp))sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }
}
