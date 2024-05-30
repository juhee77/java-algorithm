package leetcode;

class CountTirpletsThatCanFormTwoArraysOfEqualXOR_1442 {
    public int countTriplets(int[] arr) {
        int a, b;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            a = 0;
            for (int j = i; j < arr.length; j++) {
                b = 0;
                a ^= arr[j];
                for (int k = j + 1; k < arr.length; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}