package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int house = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        List<Integer> houseList = new ArrayList<>();
        for (int i = 0; i < house; i++) {
            houseList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(houseList);

        System.out.println(binarySearch(goal, house, houseList));
    }

    private static int binarySearch(int goal, int house, List<Integer> houseList) {
        int max = houseList.get(house - 1) - houseList.get(0);
        int min = 1;
        int ans = 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            int point = 0;
            int cnt = 0;
            for (int i = 0; i < house; i++) {
                if (houseList.get(i) - houseList.get(point) >= mid) {
                    point = i;
                    cnt++;
                }
            }

            if (cnt >= goal - 1) {
                min = mid + 1;
                ans = Math.max(ans,mid);
            } else {
                max = mid-1;
            }


        }
        return ans ;
    }
}
