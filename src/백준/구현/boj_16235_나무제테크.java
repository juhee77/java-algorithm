package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_16235_나무제테크 {
    private static int[][] nu;
    private static int[][] annualNu;
    private static ArrayList<Integer>[][] age;
    private static int[][] die;
    private static int[][] dir = {{-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        nu = new int[n][n];
        annualNu = new int[n][n];
        age = new ArrayList[n][n];
        die = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                age[i][j] = new ArrayList<>();
            }
        }


        //영양분
        for (int i = 0; i < n; i++) {
            Arrays.fill(nu[i], 5); //초기 칸은 모두 영양분이 5이다.
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                annualNu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //심어져 있는 나무
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int nowAge = Integer.parseInt(st.nextToken());
            age[x][y].add(nowAge);
        }

        for (int i = 0; i < k; i++) {
            //봄, 나이별로 있는경우 자신의 나이만큼 먹고 1증가
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    ArrayList<Integer> trees = new ArrayList<>(age[p][q]);
                    if (trees.size() <= 0) continue;
                    Collections.sort(trees);
                    age[p][q].clear();
                    for (Integer tree : trees) {
                        if (nu[p][q] >= tree) { //영양분을 줄수 있으면
                            nu[p][q] -= tree;  // 영양분을 줄수 있는 경우 주고 남긴다
                            age[p][q].add(tree + 1); //나무가 한살 더 먹는다.
                        } else {
                            die[p][q] += tree / 2; //죽은 나무
                        }
                    }
                }
            }

            //여름
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    nu[p][q] += die[p][q];
                    die[p][q] = 0;
                }
            }

            //가을 번식
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    ArrayList<Integer> trees = age[p][q];
                    for (Integer tree : trees) {
                        if (tree == 0) System.out.println("ERROR '0'살인 나무가 있음");
                        if (tree % 5 == 0) {
                            for (int[] ints : dir) {
                                int mvx = p + ints[0];
                                int mvy = q + ints[1];
                                if (mvx < 0 || mvy < 0 || n <= mvx || n <= mvy) continue;
                                age[mvx][mvy].add(1); //한살인 나무가 생긴다.
                            }
                        }
                    }
                }
            }

            //겨울
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    nu[p][q] += annualNu[p][q];
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += age[i][j].size();
            }
        }
        sb.append(cnt);
        System.out.println(sb);

    }

}
