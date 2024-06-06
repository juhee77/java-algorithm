package leetcode;

import java.util.Arrays;

class HandOfStraights_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        boolean[] isUsed = new boolean[hand.length];
        int usedCnt = 0;

        while (usedCnt<hand.length) {
            int cnt = 0;
            int start=0;
            for (int i = 0; i < hand.length; i++) {
                if (!isUsed[i]) {
                    start = i;
                    isUsed[i] = true;
                    cnt++;
                    break;
                }
            }

            for (int i = start; i < hand.length && cnt < groupSize; i++) {
                if(isUsed[i]) continue;

                if (hand[i] == hand[start] + 1) {
                    cnt++;
                    isUsed[i] = true;
                    start=i;
                }
            }

            if (cnt < groupSize) {
                return false;
            }

            usedCnt += groupSize;
        }
        return true;
    }
}