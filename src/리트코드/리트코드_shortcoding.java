package 리트코드;

public class 리트코드_shortcoding {
    public int maxSubArray(int[] A) {
        int max = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
    public static void main(String args[]){

    }
}
