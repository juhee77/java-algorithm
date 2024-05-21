package leetcode;

import java.util.ArrayList;
import java.util.List;

class Subsets_78 {
    private boolean[] visited;
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        visited = new boolean[nums.length];
        combination(0,nums);
        return ans;
    }

    public void combination(int d, int[] nums){
        if(d==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<d;i++){
                if(visited[i]) temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }
        visited[d] = false;
        combination(d+1,nums);
        visited[d] = true;
        combination(d+1,nums);

    }

}