package leetcode;

import java.util.Arrays;

public class MaximumIceCreamBars_1833 {
    public int maxIceCream(int[] costs, int coins) {
        int[] sort = new int[100001];
        Arrays.fill(sort,0);
        for(int cost : costs){
            sort[cost]++;
        }

        int ans = 0;
        for(int i=1;i<100001;i++){
            if(coins < i) break;

            int able = Math.min(coins/i,sort[i]);
            ans += able;
            coins -= i*able;
            // System.out.print(coins+" "+able);
        }
        return ans;
    }
    public static void main(String[] args) {
        MaximumIceCreamBars_1833 sol = new MaximumIceCreamBars_1833();

        int[] costs1 = {1, 3, 2, 4, 1};
        System.out.println(sol.maxIceCream(costs1, 7)); // 4

        int[] costs2 = {10, 6, 8, 7, 7, 8};
        System.out.println(sol.maxIceCream(costs2, 5)); // 0

        int[] costs3 = {1, 6, 3, 1, 2, 5};
        System.out.println(sol.maxIceCream(costs3, 20)); // 6
    }
}
