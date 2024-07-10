package leetcode;

class CrawlerLogFolder_1598 {
    public int minOperations(String[] logs) {
        int now = 0;
        for (String log : logs) {
            switch (log) {
                case "../":
                    if (now > 0)
                        now--;
                    break;
                case "./":
                    break;
                default:
                    now++;
            }
        }
        return now;
    }
}