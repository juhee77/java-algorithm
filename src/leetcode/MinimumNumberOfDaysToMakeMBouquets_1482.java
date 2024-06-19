package leetcode;

class MinimumNumberOfDaysToMakeMBouquets_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        // m개의 부케를 만들려고 한다., 인접한 k개의 꽃
        int max = 1_000_000_000, min = 1;
        int ans = -1;
        while (min <= max) {
            // System.out.println(min + " " + max);
            int mid = (min + max) >> 1;
            int nearF = 0;
            int group = 0;

            for (int day : bloomDay) {
                if (day <= mid) {
                    nearF++;
                } else {
                    nearF = 0;
                }

                if (k <= nearF) {
                    group++;
                    nearF = 0;
                }
            }

            if (m <= group) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
}