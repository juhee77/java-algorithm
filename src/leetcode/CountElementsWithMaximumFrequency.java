package leetcode;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        int nowMax = 0;

        int[] nowCnt = new int[101];
        int maxFrequencyCnt = 0;
        for (int num : nums) {
            nowCnt[num]++;
            if (nowCnt[num] > nowMax) {
                nowMax = nowCnt[num];
                maxFrequencyCnt = 1;
            } else if (nowCnt[num] == nowMax) {
                maxFrequencyCnt++;
            }
        }

        return maxFrequencyCnt * nowMax;
    }

    public static void main(String[] args) {
        // 4
        System.out.println(new CountElementsWithMaximumFrequency().maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        // 5
        System.out.println(new CountElementsWithMaximumFrequency().maxFrequencyElements(new int[]{1,2,3,4,5}));

    }
}
