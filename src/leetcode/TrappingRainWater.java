package leetcode;

class TrappingRainWater {
    public int trap(int[] height) {
        int[] left = new int[height.length + 2];
        int[] right = new int[height.length + 2];

        for (int i = 1; i <= height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int i = height.length; 1 <= i; i--) {
            right[i] = Math.max(right[i + 1], height[i - 1]);
        }

        int sum = 0;

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        for(int i=1;i<=height.length;i++){
            sum +=Math.max(0, Math.min(left[i],right[i])-height[i-1]);
        }
        return sum;
    }
}