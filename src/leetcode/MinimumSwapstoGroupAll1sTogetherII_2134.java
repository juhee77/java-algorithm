package leetcode;

class MinimumSwapstoGroupAll1sTogetherII_2134 {
    public int minSwaps(int[] nums) {
        int oneCnt = 0;
        int[] saveZero = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                saveZero[i + 1] = saveZero[i] + 1;
            } else {
                oneCnt++;
                saveZero[i + 1] = saveZero[i];
            }
        }

        int min = Integer.MAX_VALUE;
        // if(oneCnt==0) return 0;
        for (int i = 1; i < nums.length + 1; i++) {
            int tempOne;
            if (nums.length <= oneCnt + i) {
                tempOne = saveZero[nums.length] - saveZero[i];
                tempOne += saveZero[(i + oneCnt) % nums.length];
            } else {
                tempOne = saveZero[i + oneCnt] - saveZero[i];
            }
            min = Math.min(tempOne, min);
        }
        return min;

    }
}