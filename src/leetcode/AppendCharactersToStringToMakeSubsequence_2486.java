package leetcode;

class AppendCharactersToStringToMakeSubsequence_2486 {
    public int appendCharacters(String s, String t) {
        int temp = 0;
        for (int i = 0; i < s.length() && temp < t.length(); i++) {
            if (s.charAt(i) == t.charAt(temp)) {
                temp++;
            }
        }
        return t.length() - temp;
    }
}