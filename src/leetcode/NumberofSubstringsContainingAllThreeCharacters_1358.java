package leetcode;

import java.util.Arrays;

public class NumberofSubstringsContainingAllThreeCharacters_1358 {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        Arrays.fill(cnt, 0);
        int left = 0;
        int right = 0;
        int ans = 0;
        int len = s.length();
        char[] array = s.toCharArray();
        while (left < len) {
            if (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans += len - right + 1;
                cnt[array[left] - 'a']--;
                left++;
            }
            else if (right < len) {
                cnt[array[right] - 'a']++;
                right++;
            }
            else {
                break;
            }
        }
        return ans;
    }
}
