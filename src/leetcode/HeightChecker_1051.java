package leetcode;

class HeightChecker_1051 {
    public int heightChecker(int[] heights) {
        int[] h = new int[101];
        for(int height : heights){
            h[height]++;
        }

        int hold = 0;
        int cnt=0;
        for(int i=1;i<=100;i++){
            for(int j=0;j<h[i];j++){
                if(heights[hold++]!=i) cnt++;
            }
        }
        return cnt;
    }
}