package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1485_정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            boolean flag = true;
            List<Long> arrX = new ArrayList<>();
            List<Long> arrY = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                arrX.add(Long.parseLong(st.nextToken()));
                arrY.add(Long.parseLong(st.nextToken()));
            }

            List<Long> ans = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    ans.add(distance(arrX.get(i), arrY.get(i), arrX.get(j), arrY.get(j)));
                }
            }

            Collections.sort(ans);
//            System.out.println(ans);
            if (!Objects.equals(ans.get(0), ans.get(1))
                    || !Objects.equals(ans.get(1), ans.get(2))
                    || !Objects.equals(ans.get(2), ans.get(3))
                    || !Objects.equals(ans.get(4), ans.get(5))) {
                flag = false;
            }

            sb.append(flag ? 1 : 0).append("\n");
        }


        System.out.println(sb);
    }

    private static long distance(long x1, long y1, long x2, long y2) {
        return (long) Math.abs(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
