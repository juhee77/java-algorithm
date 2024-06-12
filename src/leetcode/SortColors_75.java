package leetcode;

class SortColors_75 {
    public void sortColors(int[] nums) {
        int[] sort = new int[3];
        for(int num:nums){
            sort[num]++;
        }

        int hold = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<sort[i];j++){
                nums[hold++] = i;
            }
        }
    }
}