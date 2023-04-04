package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 * 만약 이동한 칸에 사과가 있다면 꼬리까지 칸 유지, 만약 사과가 없다면 꼬리르 지우다
 * 사과 위치와 뱀 이동경로가 주어질때 이 게임이 몇 초에 끝나는가
 */
public class boj_3190_뱀 {
    private static final int[] head = {0, 0};
    private static final int[] tail = {0, 0};
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
        }

        int tnCnt = 2;
        map[0][0] = tnCnt;
        int cmdCnt = Integer.parseInt(br.readLine());
        int time = 1;
        boolean fin = false;
        int nowDir = 0;
        int bugsLength = 1;

        for (int i = 0; i <= cmdCnt; i++) {
            int mvTime;
            StringTokenizer st = null;
            if (i < cmdCnt) {
                st = new StringTokenizer(br.readLine());
                mvTime = Integer.parseInt(st.nextToken());
            } else
                mvTime = Integer.MAX_VALUE;

            for (; time <= mvTime; time++) {
//				System.out.println();
//				System.out.println(time + Arrays.toString(head) + " " + Arrays.toString(tail));

                // 이동한다.
                head[0] += dir[nowDir][0];
                head[1] += dir[nowDir][1];
                if (head[0] >= n || head[0] < 0 || head[1] >= n || head[1] < 0) { // 벽
                    fin = true;
//					System.out.println("BOUNDRY");
                    break;
                }

                if (map[head[0]][head[1]] >= 2) { // 자기 몸 만남
                    fin = true;
//					System.out.println("BODY");
                    break;
                }

                if (map[head[0]][head[1]] != 1) { // 사과 아님(꼬리 이동)
                    map[tail[0]][tail[1]] = 0;
                    // 4방위중 0이 아닌 숫자중에 가장 작은 숫자.
                    if (bugsLength > 1) {
                        int min = Integer.MAX_VALUE;
                        int tDir = -1;
                        for (int p = 0; p < 4; p++) {
                            int[] tdir = dir[p];
                            int mvx = tail[0] + tdir[0];
                            int mvy = tail[1] + tdir[1];
                            if (mvx < 0 || n <= mvx || mvy < 0 || n <= mvy)
                                continue;
                            if (map[mvx][mvy] >= 2 && map[mvx][mvy] < min) {
                                min = map[mvx][mvy];
                                tDir = p;
                            }

                        }

                        tail[0] += dir[tDir][0];
                        tail[1] += dir[tDir][1];
                    }
                } else if (map[head[0]][head[1]] == 1) {
                    bugsLength++;
                    map[head[0]][head[1]] = 0;
                }

                map[head[0]][head[1]] = ++tnCnt; // 머리 위치 고정

                if (bugsLength == 1) {
                    tail[0] = head[0];
                    tail[1] = head[1];
                }

//				for (int q = 0; q < N; q++) {
//					System.out.println(Arrays.toString(map[q]));
//				}
            }
            if (fin)
                break;

            if (i < cmdCnt) {
                char c = st.nextToken().charAt(0);
                if (c == 'D')
                    nowDir++;
                else
                    nowDir--;

                nowDir = (nowDir + 4) % 4;
            }
            // D (0,1) (1,0), (0,-1),(-1,0)
        }
        System.out.println(time);
    }
}
