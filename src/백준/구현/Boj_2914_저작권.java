package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2914_저작권{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int albumSongs = Integer.parseInt(st.nextToken());
        int mid = Integer.parseInt(st.nextToken());

        System.out.println(albumSongs*(mid-1)+1);
    }
}
