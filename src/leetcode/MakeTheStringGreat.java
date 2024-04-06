package leetcode;

class MakeTheStringGreat {
    public String makeGood(String s) {
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (Character.isLowerCase(s.charAt(i)) && Character.toUpperCase(s.charAt(i)) == s.charAt(i + 1)) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    flag = true;
                    break;
                }
                if (Character.isUpperCase(s.charAt(i)) && Character.toLowerCase(s.charAt(i)) == s.charAt(i + 1)) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    flag = true;
                    break;
                }
            }
        }
        return s;
    }
}