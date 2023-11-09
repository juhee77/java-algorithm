package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3515_합이0 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        long cnt = 0;

        for (int i = 0; i < N && nums[i] <= 0; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    if (nums[left] == nums[right]) {
                        cnt += combi(right - left + 1);
                        break;
                    }

                    int l = 1;
                    int r = 1;

                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                        l++;
                    }

                    while (left < right - 1 && nums[right] == nums[right - 1]) {
                        right--;
                        r++;
                    }

                    cnt += (long) r * l;
                }


                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(cnt);
    }

    private static long combi(int n) {
        return (long) n * (n - 1) / 2;
    }
}
