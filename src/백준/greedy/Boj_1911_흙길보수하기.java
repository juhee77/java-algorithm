package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1911_흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<int[]> arr = new ArrayList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new int[]{start, 1});
            arr.add(new int[]{end, -1});
        }

        arr.sort(Comparator.comparingInt(o -> o[0]));
        int nowCover = 0;
        int cnt = 0;
        for (int[] poll : arr) {
            if (poll[1] == 1) {
                nowCover = Math.max(nowCover, poll[0]);
            } else {
                if (nowCover < poll[0]) {
                    int needLen = (poll[0] - nowCover);
                    int need = needLen % l == 0 ? needLen / l : needLen / l + 1;
                    cnt += need;
                    nowCover = nowCover + l * need;
                }
            }
        }
        System.out.println(cnt);
    }
}
