package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2258_정육점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //덩어리 개수
        int needWeight = Integer.parseInt(st.nextToken()); //필요한 고기의 양

        //무게 가격
        int totalWeight = 0;
        List<int[]> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            all.add(new int[]{weight, money});
            totalWeight += weight;
        }

        if (totalWeight < needWeight) {
            System.out.println(-1);
        } else {
            all.sort((o1, o2) -> {
                if (o1[1] == o2[1]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            });

            int[][] subStm = new int[n + 1][2]; // 무게, 가격
            for (int i = 1; i <= n; i++) {
                if (i > 1 && all.get(i - 1)[1] == all.get(i - 2)[1]) {
                    subStm[i][1] = subStm[i - 1][1] + all.get(i - 1)[1];
                } else {
                    subStm[i][1] = all.get(i - 1)[1];
                }
                subStm[i][0] = subStm[i - 1][0] + all.get(i - 1)[0];
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (subStm[i][0] >= needWeight) {
                    ans = Math.min(ans, subStm[i][1]);
                }
            }
            System.out.println(ans);
        }
    }
}
