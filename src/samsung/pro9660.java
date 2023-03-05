package samsung;

import java.util.Scanner;
import java.util.StringTokenizer;

public class pro9660 {
    private static boolean[] visit;
    private static long[] arr;
    private static long[] hates;
    private static long cnt = 0;

    private static void backtracking(int number,int size, int d) {
        if (size+ 1 == d) {
            cnt++;
            cnt %= 1000000007;
        } else {
            for (int i = 1; i <= number; i++) {
                if (!visit[i] && hates[d] != i) {
                    visit[i] = true;
                    arr[d] = i;
                    backtracking(number, size,d + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            int number = Integer.parseInt(sc.nextLine());
            hates = new long[number + 1];
            int hatecnt = 1;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int i = 1; i <= number; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > 0 && number >= temp) {
                    hates[hatecnt++] = temp;
                }
            }

            int remaincnt = (number-hatecnt+1);
            arr = new long[hatecnt];
            visit = new boolean[number+1];

            backtracking(number,hatecnt-1  , 1);

            if (remaincnt == 0) System.out.println("#" + test_case + " " + cnt % 1000000007);
            else{
                long remain = 1;
                for (int i = 1; i <= remaincnt; i++) {
                    remain = (remain % 1000000007 * i) % 1000000007;
                }
                System.out.println("#" + test_case + " " + ((cnt*remain)% 1000000007));
            }

        }
    }
}