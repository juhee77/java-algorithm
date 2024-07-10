package leetcode;

class FindTheMinimumAndMaximun_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        Integer l = null, ll = null;
        Integer startIdx = null, beforeIdx = null;
        int ansMin = -1, ansMax = -1;
        int cnt = 0;
        while (head != null) {
            if (ll == null) {
                ll = head.val;
            } else if (l == null) {
                l = head.val;
            } else {
                if (ll < l && head.val < l || l < ll && l < head.val) {
                    if (startIdx == null) startIdx = cnt;
                    if (beforeIdx == null) beforeIdx = cnt;
                    else {
                        if (ansMin == -1) ansMin = Integer.MAX_VALUE;
                        ansMin = Math.min(ansMin, cnt - beforeIdx);
                        ansMax = Math.max(ansMax, cnt - startIdx);
                        beforeIdx = cnt;
                    }
                }
                ll = l;
                l = head.val;
            }
            cnt++;
            head = head.next;
        }

        //System.out.println(ans);
        return new int[]{ansMin, ansMax};
    }
}