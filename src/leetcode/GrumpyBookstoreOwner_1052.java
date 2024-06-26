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
        for (int i = minutes + 1; i <= cLen; i++) {
            // i-m ~~ i 까지의 값을 모두 취한다고 생각 
            // 즉 0~k , k+m ~end 까지는  subSUm에서 
            // k~k+m까지는 sum에서 취함 
            int left = subSum[i - minutes] - subSum[0];
            int right = subSum[cLen - 1] - sum[i];
            int now = sum[i] - sum[i - minutes - 1];

            max = Math.max(max, left + right + now);
        }
        return max;
    }
}