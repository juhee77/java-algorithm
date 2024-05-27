package leetcode;

class SpecialArrayWithXElementsGreaterThanOrEqualX_1608 {
    public int specialArray(int[] nums) {
        int[] subSet = new int[1001];

        for(int num:nums){
            subSet[num]++;
        }

        int hold = 0;
        for(int i=0;i<=1000;i++){
            if(nums.length-hold == i) return i;
            hold = hold + subSet[i];
        }
        return -1;
    }
}