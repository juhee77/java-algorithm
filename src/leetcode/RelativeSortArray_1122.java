package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> remain = new ArrayList<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            hashMap.put(arr2[i], i);
        }
        int[] dict = new int[arr2.length];

        for (int i : arr1) {
            if (hashMap.containsKey(i)) {
                dict[hashMap.get(i)]++;
            } else {
                remain.add(i);
            }
        }

        int[] ans = new int[arr1.length];
        int hold = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < dict[i]; j++) {
                ans[hold++] = arr2[i];
            }
        }

        Collections.sort(remain);
        for (Integer next : remain) {
            ans[hold++] = next;
        }

        return ans;
    }
}