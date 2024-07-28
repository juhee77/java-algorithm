package leetcode;

class RemoveDuplicatesfromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int hold = 0;
        int before = -1;
        int index = 0;
        for (int num : nums) {
            if (before == num) {
                hold++;
            } else {
                before = num;
                hold = 1;
            }

            if (hold <= 2) {
                nums[index++] = num;
            }
        }
        return index;
    }
}