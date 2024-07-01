package leetcode;

class ThreeConsecutiveOdds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCnt = 0;
        for(int temp : arr){
            if((temp&1) >= 1) oddCnt++;
            else oddCnt = 0;
            
            if(oddCnt==3) return true;
        }
        return false;
    }
}