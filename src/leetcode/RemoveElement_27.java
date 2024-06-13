package leetcode;

class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        int cnt = 0;

        while (left <= right && 0 <= right) {
            while (0 <= right && nums[right] == val) {
                right--;
            }
            if (left > right)
                break;

            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            }

            cnt++;
            left++;
        }
        return cnt;
    }
}