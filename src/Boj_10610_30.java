import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        int zeroCnt = 0;

        for (char c : br.readLine().toCharArray()) {
            int num = c - '0';
            if (num == 0) {
                zeroCnt++;
            } else {
                arr.add(num);
                sum += num;
            }
        }

        if (sum % 3 != 0 || zeroCnt < 1) {
            System.out.println(-1);
        } else {
            Collections.sort(arr,Collections.reverseOrder());
            for (Integer integer : arr) {
                sb.append(integer);
            }
            for (int i = 0; i < zeroCnt; i++) {
                sb.append("0");
            }
            System.out.println(sb);
        }


    }
}
