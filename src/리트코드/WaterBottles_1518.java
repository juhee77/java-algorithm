package 리트코드;

class WaterBottles_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {

        int cnt = numBottles;
        while (numBottles >= numExchange) {
            int made = numBottles / numExchange;
            numBottles %= numExchange;
            numBottles += made;
            cnt += made;
        }
        return cnt;
    }
}