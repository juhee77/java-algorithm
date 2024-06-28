package leetcode;

class GrumpyBookstoreOwner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int cLen = customers.length;
        int[] subSum = new int[cLen + 1];
        int[] sum = new int[cLen + 1];
        for (int i = 1; i <= cLen; i++) {
            if (grumpy[i - 1] == 0) subSum[i] = subSum[i - 1] + customers[i - 1];
            else subSum[i] = subSum[i - 1];
            sum[i] = sum[i - 1] + customers[i - 1];
        }

        int max = 0;
        for (int i = minutes; i <= cLen; i++) {
            int left = subSum[i - minutes] - subSum[0];
            int right = subSum[cLen] - subSum[i];
            int now = sum[i] - sum[i - minutes];

            max = Math.max(max, left + right + now);
        }
        return max;
    }
}