package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9177_단어섞기1_DFS {
    private static char[][] input = new char[3][];
    private static boolean flag = true;
    private static int[] check = new int[125];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Loop:
        for (int i = 1; i <= n; i++) {
            sb.append("Data set ").append(i).append(": ");
            st = new StringTokenizer(br.readLine());
            flag = false;
            for (int j = 0; j < 2; j++) {
                char[] chars = st.nextToken().toCharArray();
                for (char aChar : chars) {
                    check[aChar]++; //기존에 있는 단어의 개수를 체크
                }
                input[j] = chars;
            }

            //마지막 문자 처리
            char[] chars = st.nextToken().toCharArray();
            for (char aChar : chars) {
                if (check[aChar] == 0) {
                    sb.append("no").append("\n");
                    continue Loop;
                }
                check[aChar]--;
            }
            input[2] = chars;

            findAllCase(0, 0, 0);
            sb.append(flag ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }

    private static void findAllCase(int idx1, int idx2, int nowDepth) {
        if (flag) return;
        if (input[2].length == nowDepth) {
            flag = true;
        } else {
            if (idx1 < input[0].length) {
                if (input[2][nowDepth] == input[0][idx1]) {
                    findAllCase(idx1 + 1, idx2, nowDepth + 1);
                }
            }

            if (idx2 < input[1].length && !flag) {
                if (input[2][nowDepth] == input[1][idx2]) {
                    findAllCase(idx1, idx2 + 1, nowDepth + 1);
                }
            }
        }
    }
}
//bbbb bbbbasdf bbbbasdfbbbb
