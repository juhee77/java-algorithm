package leetcode;

class AverageWaitingTime_1701 {
    public double averageWaitingTime(int[][] customers) {
        double waitTime = 0;
        double nowTime = 0;
        for (int i = 0; i < customers.length; i++) {
            if (nowTime < customers[i][0])
                nowTime = customers[i][0] + customers[i][1];
            else
                nowTime += customers[i][1];
            waitTime = waitTime + (nowTime - customers[i][0]);
        }
        return waitTime / customers.length;
    }
}