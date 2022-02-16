package 리트코드;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max=nums[1];
        int Realmax=0;

        for(int i=1;i<nums.length;i++){
            if(max+nums[i]>=0)
                max=max+nums[i];

            else if(max+nums[i]<0)
                max=0;

            Realmax = Math.max(max,Realmax);
        }
        return Realmax;
    }
    public static void main(String args[]){
        int a[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(a));
    }
}
