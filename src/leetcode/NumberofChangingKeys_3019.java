package leetcode;

class NumberofChangingKeys_3019 {
    public int countKeyChanges(String s) {
        char before = s.charAt(0);
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (Character.toUpperCase(c) == before || before == Character.toLowerCase(c)) {
                continue;
            } else {
                cnt++;
                before = c;
            }
        }
        return cnt;
    }
}