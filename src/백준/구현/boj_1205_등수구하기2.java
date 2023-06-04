package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1205_등수구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int nowRankCnt = Integer.parseInt(st.nextToken()); //리스트에 있는 점수 N개 (p보다 작거나 같음)
        int tesoScore = Integer.parseInt(st.nextToken()); //태수의 점수
        int ableRankCnt = Integer.parseInt(st.nextToken()); //p 랭킹 리스트에 올라갈 수있는 점수(10~50)

        int tesoRank = -1;
        int minScore = 2000000000;
        if (nowRankCnt > 0) {//현재 랭킹이 있는 경우에 현재 랭킹 리스트에 있는 점수
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < nowRankCnt; i++) {
                minScore = Integer.parseInt(st.nextToken());

                if (tesoRank == -1 && tesoScore >= minScore) {
                    tesoRank = (i + 1);//등수 갱신
                }
            }
        }


        if (tesoRank == -1) {
            if (nowRankCnt < ableRankCnt) {
                System.out.println(nowRankCnt + 1); //꼴지 가능
            } else {
                System.out.println(-1); //불가능한 경우
            }
        } else {
            if (minScore == tesoScore && nowRankCnt == ableRankCnt) {
                System.out.println(-1);
            } else {
                System.out.println(tesoRank);
            }
        }


    }
}

/*

5 50 5
100 90 80 70 60
-1
 */
