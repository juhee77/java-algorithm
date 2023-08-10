package 백준.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int dishCnt = Integer.parseInt(st.nextToken());
        int susiCnt = Integer.parseInt(st.nextToken());
        int chainCnt = Integer.parseInt(st.nextToken());//연속해서
        int coupon = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] susi = new int[dishCnt];
        for (int i = 0; i < dishCnt; i++) {
            susi[i] = Integer.parseInt(br.readLine());
        }


        HashMap<Integer, Integer> eaten = new HashMap<>();
        eaten.put(coupon, 1); //이미 먹은것
        for (int right = 0; right < chainCnt; right++) {
            eaten.put(susi[right], eaten.getOrDefault(susi[right], 0) + 1);
        }
        max = Math.max(max, eaten.size());

        //이동하면서 확인
        for (int right = chainCnt; right < dishCnt + chainCnt - 1; right++) {
            int left = susi[(right - chainCnt) % dishCnt];
            if (eaten.get(left) == 1) {
                eaten.remove(left);
            } else {
                eaten.put(left, eaten.get(left) - 1); //먹은거에서 제거
            }

            int key = susi[right % dishCnt];
            eaten.put(key, eaten.getOrDefault(key, 0) + 1);
            max = Math.max(max, eaten.size());
        }

        System.out.println(max);
    }
}