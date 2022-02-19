package 리트코드;

import java.util.HashMap;
import java.util.Iterator;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(nums[i])==false)
                hash.put(nums[i],0);
            else //if it has
                hash.remove(nums[i]);
        }
        Iterator<Integer> key=hash.keySet().iterator();
        return key.next();

    }
    public static void main(String args[]){
        int[] a = {4,2,1,2,1};
        System.out.println(singleNumber(a));
    }
}
