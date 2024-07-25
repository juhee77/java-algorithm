package leetcode;

class SortAnArray_912 {
    private static int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return temp;
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            int p = start;
            int q = mid + 1;
            int index = p;

            // merge
            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && nums[p] < nums[q])) {
                    temp[index++] = nums[p++];
                } else {
                    temp[index++] = nums[q++];
                }
            }

            if (end + 1 - start >= 0)
                System.arraycopy(temp, start, nums, start, end + 1 - start);
        }
    }
}