package leetcode;

class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int left = 0;
        int wildcard = 0;
        char[] charArray = s.toCharArray();

        for (char aChar : charArray) {
            if (aChar == '(') {
                left++;
            } else if (aChar == '*') {
                wildcard++;
                if (left != 0) {
                    left--;
                    wildcard++;
                }
            } else if (aChar == ')') {
                if (left != 0) {
                    left--;
                } else if (wildcard != 0) {
                    wildcard--;
                } else
                    return false;
            }
        }

        return left == 0;
    }
}
