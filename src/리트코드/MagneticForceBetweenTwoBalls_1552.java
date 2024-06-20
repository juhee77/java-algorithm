package 리트코드;

import java.util.Arrays;

class MagneticForceBetweenTwoBalls_1552 {
    public int maxDistance(int[] position, int m) {
        int left = 0, right = 1_000_000_000;
        Arrays.sort(position);
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int hold = 0;
            int usedBasket = 0;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - position[hold] >= mid) {
                    usedBasket++;
                    hold = i;
                }
            }

            if (usedBasket < m-1) {
                right = mid - 1;
            } else {
                ans = Math.max(mid, ans);
                left = mid + 1;
            }
        }
        return ans;
    }
}