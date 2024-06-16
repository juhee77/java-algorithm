package leetcode;

class PatchingArray_330 {
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long coverage = 1; //만약 1이 없으면 어떻게 되는거지? TODO
        int holdIndex = 0;
        while (coverage <= n) {
            if (holdIndex < nums.length && nums[holdIndex] <= coverage) {
                coverage += nums[holdIndex++];
            }else{
                //coverage+1 = coverage+1 안에 것 모두 가능하게 되므로 커버리지 이상의 것이 가능
                coverage += coverage;
                patch++;
            }
        }
        return patch;
    }
}