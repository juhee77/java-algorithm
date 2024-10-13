package 리트코드;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {

        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                return true;
            list.add(nums[i]);
        }
        return false;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 1};
        System.out.print(containsDuplicate(a));
    }

    ///위에 복잡도 문제로 시간더 오래걸림
    //아래처럼 하는게 시간이 더 적게걸림
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1])
                    return true;
            }
            return false;
        }
    }
}
