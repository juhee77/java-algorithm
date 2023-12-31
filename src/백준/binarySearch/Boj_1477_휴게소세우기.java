package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1477_휴게소세우기 {
    private static int m;
    private static final List<Integer> restingPlace = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //휴게소 개수
        m = Integer.parseInt(st.nextToken()); //휴게소 사용가능 개수
        int l = Integer.parseInt(st.nextToken()); //고속도로 길이
        int max = l;

        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                restingPlace.add(Integer.parseInt(st.nextToken()));
            }
        }

        restingPlace.add(0); //시작지점
        restingPlace.add(l);// 마지막 지점
        Collections.sort(restingPlace);
        for (int i = 1; i <= n; i++) {
            int diff = restingPlace.get(i) - restingPlace.get(i - 1);
            max = Math.max(max, diff);
        }

        int start = 1;
        int end = max;
        int ans = max;

        while (start <= end) {
            int mid = (start + end) >> 1;

            if (isAble(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean isAble(int mid) {
        int tempRestingPlaceCnt = 0;

        for (int i = 1; i < restingPlace.size(); i++) {
            int diff = restingPlace.get(i) - restingPlace.get(i - 1);
            if ( mid < diff) {
                if (diff % mid == 0) {
                    tempRestingPlaceCnt += ((diff / mid)-1);
                }
                else tempRestingPlaceCnt += (diff / mid);
            }

            if (tempRestingPlaceCnt > m) {
                return false;
            }
        }

        return true;
    }
}
