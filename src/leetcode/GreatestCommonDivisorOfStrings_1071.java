package leetcode;

class GreatestCommonDivisorOfStrings_1071 {

    /**
     * 문제 이해를 잘하자
     * s = t+t+t 라 했다.. (결국 최소 공배수로 해결할 수 있는 문제)
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public String gcdOfStrings3(String str1, String str2) {
        // Check if they have non-zero GCD string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public String gcdOfStrings2(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); 1 <= i; i--) {
            String find = str2.substring(0, i);
            String replace = str1.replace(find, "");
            if (replace.equals("")) {
                replace = str2.replace(find, "");
                if (replace.equals("")) return find;
            }
        }
        return "";
    }


    public boolean valid(String str1, String str2, int k) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }


    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }
}