package 리트코드;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarray_modi {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxarr[] = new int[nums.length];
        maxarr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            System.out.print(max + "  ");
            maxarr[i] = Math.max(nums[i], Math.max(max + nums[i], maxarr[i - 1]));
            if (max + nums[i] < 0)
                max = nums[i];
            else
                max = Math.max(nums[i], max + nums[i]);

        }

        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(maxarr[i] + "  ");
        }


        Arrays.sort(maxarr);


        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(maxarr[i] + "  ");
        }
        System.out.println();

        return maxarr[nums.length - 1];
    }

    public static void main(String args[]) {
        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
        int b[] = {1};
        System.out.println(maxSubArray(b));
        int c[] = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(c));
        int d[] = {-3, 2, 3, 0, -1};
        System.out.println(maxSubArray(d));
    }


    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        int maxarr[] = new int[nums.length];
        maxarr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxarr[i] = Math.max(nums[i], Math.max(max + nums[i], maxarr[i - 1]));
            if (max + nums[i] < 0)
                max = nums[i];
            else
                max = Math.max(nums[i], max + nums[i]);
        }
        Arrays.sort(maxarr);
        return maxarr[nums.length - 1];
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int nowmax = nums[0];
        int nextmax = 0;
        //int maxarr[]=new int[nums.length];
        //maxarr[0]=nums[0];

        for (int i = 1; i < nums.length; i++) {
            nextmax = Math.max(nums[i], Math.max(max + nums[i], nowmax));
            if (max + nums[i] < 0)
                max = nums[i];
            else
                max = Math.max(nums[i], max + nums[i]);
            nowmax = nextmax;
        }
        return nowmax;
    }


}