package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Boj_10827_ab {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();  // 입력된 소수 문자열
        int b = Integer.parseInt(st.nextToken());  // 제곱할 횟수

        // BigDecimal을 사용하여 입력된 소수와 제곱 횟수를 처리
        BigDecimal base = new BigDecimal(a);
        BigDecimal result = base.pow(b);  // 제곱 계산

        // 결과를 문자열로 변환하여 출력
        System.out.println(result.stripTrailingZeros().toPlainString());
    }
}
