package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1802_종이접기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //1 out(시계 방향 ), 0 in(반시계방향)
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] charArray = br.readLine().toCharArray();
            if (check(charArray, 0, charArray.length - 1)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    public static boolean check(char[] arr, int start, int end) {
        //정확하게 반대 여야 한다.
        int mid = (start + end) >> 1;
        if (start == mid) return true;

        for (int i = 0; i < (mid - start); i++) {
//            System.out.println(String.format("index %d, char %c :: index %d, char %c",start+i,arr[start+1],end-i,arr[end-i]));
            if (arr[start + i] == arr[end - i]) return false;
        }
        return check(arr, start, mid - 1) && check(arr, mid + 1, end);
    }
}
