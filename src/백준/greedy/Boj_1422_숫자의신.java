package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1422_숫자의신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<String> numbers = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < a; i++) {
            String e = br.readLine();
            numbers.add(e);
            max = Math.max(Integer.parseInt(e), max);
        }

        numbers.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        boolean flag = true;

        for (String number : numbers) {
            sb.append(number);
            if (max == Integer.parseInt(number) && flag) { //최댓값을 반복한다.
                for (int i = a; i < b; i++) {
                    sb.append(number);
                    flag = false;
                }
            }
        }


        System.out.println(sb);

    }
}
