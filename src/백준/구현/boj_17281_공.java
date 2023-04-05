package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17281_공 {
    private static int inning;
    private static int[][] score;
    private static final int NINE = 9;
    private static final int[] permu = new int[NINE];
    private static final boolean[] visited = new boolean[NINE];
    private static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        inning = Integer.parseInt(br.readLine());
        score = new int[inning][NINE];
        for (int j = 0; j < inning; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < NINE; i++) {
                score[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        // 4번째 타수는 이미 결정되었다.
        permu[3] = 0;
        visited[0] = true;
        dfs(0);
        System.out.println(maxScore);
    }

    private static void dfs(int nowDepth) {
        if (nowDepth == NINE) {
            // System.out.println(Arrays.toString(permu));
            checkScore();
        } else if (nowDepth == 3) {
            dfs(nowDepth + 1);
        } else {
            for (int i = 0; i < NINE; i++) {
                if (visited[i])
                    continue;

                visited[i] = true;
                permu[nowDepth] = i;
                dfs(nowDepth + 1);
                visited[i] = false;
            }
        }

    }

    private static void checkScore() {
        boolean[] people;

        int nowScore = 0;
        int outScore;
        int nowPlayer = 0;
        for (int i = 0; i < inning; i++) {
            people = new boolean[4];
            outScore = 0;
            while (outScore < 3) { // 3아웃
                nowPlayer %= 9;
                if (score[i][permu[nowPlayer]] == 0)
                    outScore++;
                else {
                    // 뒤에서 부터 가장 점수를 옮긴다.
                    int tempScore = score[i][permu[nowPlayer]];

                    if (tempScore == 4) {// 홈런
                        for (int k = 0; k <= 3; k++) {
                            if (people[k]) {
                                people[k] = false;
                                nowScore++;
                            }
                        }
                        nowScore++;// 자기자신까지
                    } else { // 1,2,3
                        for (int k = 3; 1 <= k; k--) {

                            if (people[k]) {
                                people[k] = false;
                                if (k + tempScore >= 4)
                                    nowScore++;
                                else
                                    people[k + tempScore] = true;
                            }
                        }
                        people[tempScore] = true;
                    }
                }
                nowPlayer++;
            }
        }
        // System.out.println(nowScore);
        maxScore = Math.max(nowScore, maxScore);
    }
}
