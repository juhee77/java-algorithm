package leetcode;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning_131 {
    char[] charArray;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        charArray = s.toCharArray();

        find(s, 0, 0, new ArrayList<>());
        return ans;
    }

    private void find(String s, int last, int now, ArrayList<String> temp) {

        if (now == s.length()) {
            //System.out.println(temp);
            if (last == now) {
                ans.add((ArrayList<String>) temp.clone());
            }
            return;
        }

        String substring = s.substring(last, now + 1);
        if (isPalindrome(substring)) {
            temp.add(substring);
            find(s, now + 1, now + 1, temp);
            temp.remove(temp.size() - 1);
        }
        find(s, last, now + 1, temp);

    }

    public static boolean isPalindrome(String s) {
        if (s.length() < 1) {
            return true;
        }

        for (int i = 0; i < (s.length() + 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}