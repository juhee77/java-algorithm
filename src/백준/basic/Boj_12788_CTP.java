package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12788_CTP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String problemType = st.nextToken();

            st = new StringTokenizer(br.readLine());
            if (problemType.equals("C")) {
                for (int j = 0; j < M; j++) {
                    char alphabet = st.nextToken().charAt(0);
                    int number = alphabet - 'A' + 1;
                    resultBuilder.append(number).append(" ");
                }
            } else {
                for (int j = 0; j < M; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    char alphabet = (char) ('A' + number - 1);
                    resultBuilder.append(alphabet).append(" ");
                }
            }
            resultBuilder.append("\n");
        }
        System.out.println(resultBuilder);
    }
}
