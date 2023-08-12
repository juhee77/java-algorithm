package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16439_치킨치킨치킨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //n,m mCn
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] score = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {

                    //최대 점수를 확인
                    int tempMax = 0;
                    for (int row = 0; row < n; row++) {
                        tempMax += Math.max(Math.max(score[row][i], score[row][j]), score[row][k]);
                    }
                    maxScore = Math.max(tempMax, maxScore);

                }
            }
        }

        System.out.println(maxScore);
    }
}
