package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionOfTwoArrays2_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int left = 0, right = 0;
        List<Integer> arr = new ArrayList<>();
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right]) {
                left++;
            } else if (nums1[left] == nums2[right]) {
                arr.add(nums1[left]);
                left++;
                right++;
            } else {
                right++;
            }
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int hand1 = 0, hand2 = 0, hold = 0;
        while (hand1 < nums1.length && hand2 < nums2.length) {
            if (nums1[hand1] < nums2[hand2]) {
                hand1++;
            } else if (nums1[hand1] == nums2[hand2]) {
                nums1[hold++] = nums2[hand2];
                hand1++;
                hand2++;
            } else {
                hand2++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, hold);
    }

}