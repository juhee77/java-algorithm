package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1052_물병 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(solution(x, y));
    }

    private static int solution(int x, int y) {
        int temp = 0;

        String s = Integer.toBinaryString(x); // 이진법 변환
        for (int i = s.length() - 1; 0 <= i; i--) {
            System.out.println(s+" "+i);
            if (Integer.bitCount(x) <= y) return temp;
            if (s.charAt(i) == '1') {
                x += 1 << (s.length() - i - 1); //1인것이 있으면 해당 숫자를 더한다 -> 001 이였다면 010으로 변화
                temp += 1 << (s.length() - i - 1); // 구매한 물병 만큼 더한다.
            }
            s = Integer.toBinaryString(x); //더한 값으로 이진법 수정한다.
        }
        /*
        i의 위치는 0까지 돌게 되어서 마지막 상황까지 파악하기때문에 상관이 없을것으로 생각했다.
        모든 상황에서 제일 앞은 1이므로
         */
        return -1;
    }
}
