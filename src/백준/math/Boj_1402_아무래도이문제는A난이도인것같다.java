package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1402_아무래도이문제는A난이도인것같다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            st = new StringTokenizer(br.readLine());
//            int multiply = Integer.parseInt(st.nextToken());
//            int sum = Integer.parseInt(st.nextToken());
//
//            int nowSum = 0;
//            int temp = multiply;
//            while (multiply != sum && 1 < temp) {
//                for (int i = multiply; i <= multiply; i++) {
//                    if (temp % i == 0) {
//                        nowSum += (i);
//                        temp /= i;
//                        break;
//                    }
//                }
//            }
//
//            if (sum == nowSum || multiply == sum)
//                sb.append("yes\n");
//            else {
//                sb.append("no\n");
//            }
            // 1, -1 로 채워서 커버할 수 있다.
            sb.append("yes").append("\n");
        }
        System.out.println(sb);

    }
}
