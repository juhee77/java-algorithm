package leetcode;

public class ProcessStringWithSpecialOperations_3612 {
    class Solution {
        public String processStr(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    if (sb.length() >= 1)
//                        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
                        sb.deleteCharAt(sb.length() - 1);
                } else if (c == '#') {
                    sb = sb.append(sb.toString());
                } else if (c == '%') {
                    sb = sb.reverse();
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
