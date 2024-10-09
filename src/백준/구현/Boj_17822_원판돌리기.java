package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17822_원판돌리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int boardCnt = Integer.parseInt(st.nextToken());
        int eachBoardCnt = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        int[][] rulet = new int[boardCnt][eachBoardCnt];
        int[][] cpyRulet = new int[boardCnt][eachBoardCnt];
        for (int i = 0; i < boardCnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < eachBoardCnt; j++) {
                rulet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //현재 시작칸
        int[] dirHold = new int[boardCnt];
//        print(n, m, rulet, dirHold);

        for (int t = 0; t < turn; t++) {
            //회전
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int notTurn = x; notTurn <= boardCnt; notTurn += x) {
                int notTurn1 = notTurn - 1;
                dirHold[notTurn1] = (dir == 0) ? dirHold[notTurn1] - k : dirHold[notTurn1] + k;
                dirHold[notTurn1] = (dirHold[notTurn1] + eachBoardCnt) % eachBoardCnt;
            }
//            System.out.println(Arrays.toString(dirHold));
//            print(boardCnt, eachBoardCnt, rulet, dirHold);

            copyArray(cpyRulet, rulet);

            //인접한것 찾고 계산
            boolean isChanged = false;
            for (int p = 0; p < boardCnt; p++) {
//                print(boardCnt, eachBoardCnt, rulet, dirHold);

                //하나의 원판 안에서 인접하는 경우
                for (int q = 0; q < eachBoardCnt; q++) {
                    if (rulet[p][q] == 0) continue;
                    int convert = convert(q - 1, eachBoardCnt);
                    if (rulet[p][q] == rulet[p][convert]) {
                        isChanged = true;
                        cpyRulet[p][q] = cpyRulet[p][convert] = 0;
                    }

                    convert = convert(q + 1, eachBoardCnt);
                    if (rulet[p][q] == rulet[p][convert]) {
                        isChanged = true;
                        cpyRulet[p][q] = cpyRulet[p][convert] = 0;
                    }
                }

                //원판 위아래로 켭치는게 없는 경우
                for (int q = 0; q < eachBoardCnt; q++) {
                    int conv = convert(q + dirHold[p], eachBoardCnt);
                    if (rulet[p][conv] == 0) continue;

                    if (0 < p) {
                        int pConv = convert(q + dirHold[p - 1], eachBoardCnt);
                        if (rulet[p][conv] == rulet[p - 1][pConv]) {
                            isChanged = true;
                            cpyRulet[p][conv] = cpyRulet[p - 1][pConv] = 0;
                        }
                    }

                    if (p < boardCnt - 1) {
                        int pConv = convert(q + dirHold[p + 1], eachBoardCnt);
                        if (rulet[p][conv] == rulet[p + 1][pConv]) {
                            isChanged = true;
                            cpyRulet[p][conv] = cpyRulet[p + 1][pConv] = 0;
                        }
                    }
                }
            }

//            System.out.println("flag = " + flag);
            if (!isChanged) {
                double sum = 0;
                int cnt = 0;
                for (int[] nowBoard : cpyRulet) {
                    for (int i : nowBoard) {
                        if (i == 0) continue;
                        sum += i;
                        cnt++;
                    }
                }

                double avg = sum / cnt;
                for (int p = 0; p < boardCnt; p++) {
                    for (int q = 0; q < eachBoardCnt; q++) {
                        if (cpyRulet[p][q] == 0) continue;
                        if (cpyRulet[p][q] < avg) {
                            cpyRulet[p][q]++;
                        } else if (cpyRulet[p][q] > avg) {
                            cpyRulet[p][q]--;
                        }
                    }
                }
            }
            copyArray(rulet, cpyRulet);
        }

        int ans = 0;
        for (int[] ints : rulet) {
            for (int anInt : ints) {
                ans += anInt;
            }
        }
        System.out.println(ans);

    }

    private static void copyArray(int[][] copied, int[][] target) {
        for (int j = 0; j < copied.length; j++) {
            copied[j] = target[j].clone();
        }
    }

    private static void print(int n, int m, int[][] cpyRulet, int[] dirHold) {
        System.out.println();
        for (int pr = 0; pr < n; pr++) {
            for (int prl = dirHold[pr]; prl < dirHold[pr] + m; prl++) {
                System.out.printf(cpyRulet[pr][convert(prl, m)] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int convert(int j, int hold) {
        return (j + hold) % hold;
    }
}
