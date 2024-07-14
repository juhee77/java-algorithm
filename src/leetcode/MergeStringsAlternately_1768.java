package leetcode;

class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        int w1Idx = 0, w2Idx = 0;
        StringBuilder sb = new StringBuilder();

        while (w1Idx < word1.length() && w2Idx < word2.length()) {
            sb.append(word1.charAt(w1Idx++));
            sb.append(word2.charAt(w2Idx++));
        }

        if (w1Idx < word1.length()) {
            sb.append(word1.substring(w1Idx));
        }
        if (w2Idx < word2.length()) {
            sb.append(word2.substring(w2Idx));
        }
        return sb.toString();
    }
}