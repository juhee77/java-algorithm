package leetcode;

class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == -1) return word;

        String prefix = new StringBuilder(word.substring(0, i + 1)).reverse().toString();
        return prefix + word.substring(i + 1);
    }
}