package leetcode;

import java.util.HashSet;
import java.util.List;

class ReplaceWords_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> replacedSet = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        String[] split = sentence.split(" ");
        for (String s : split) {
            sb.append(contain(replacedSet, s)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String contain(HashSet<String> set, String word) {
        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(0, i + 1);
            if (set.contains(temp)) {
                return temp;
            }
        }
        return word;
    }
}