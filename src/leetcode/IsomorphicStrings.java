package leetcode;

import java.util.Arrays;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[200];
        Arrays.fill(map, -1);
        boolean[] isUsed = new boolean[200];

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != -1) {
                if (map[s.charAt(i)] != t.charAt(i))
                    return false;
            } else {

                if (isUsed[t.charAt(i)])
                    return false;

                isUsed[t.charAt(i)] = true;
                map[s.charAt(i)] = t.charAt(i);
            }
        }

        return true;
    }
}