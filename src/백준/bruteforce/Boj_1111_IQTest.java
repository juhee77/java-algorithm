package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1111_IQTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n==2){
            if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
                return;
            }
        }

        if (n <= 2) {
            System.out.println("A");
            return;
        }

        int foundCnt = 0;
//        int next = Integer.MAX_VALUE;
        int tempB = 0;
        Set<Integer> foundSet = new HashSet<>();
        for (int a = -200; a <= 200 && foundCnt < 2; a++) {
            boolean isAble = true;
            tempB = arr[1] - arr[0] * a;
            for (int i = 2; i < n; i++) {
                if (arr[i - 1] * a + tempB != arr[i]) {
                    isAble = false;
                    break;
                }
            }

//            int foundNum = arr[n - 1] * a + tempB;
//            if (isAble && next != foundNum) {
//                  이렇게 하고 싶으면 next가 절대 나올 수 없는 값으로 해야함 같을수도 있음 그러면 하나가 무시되는꼴임
////                    System.out.println("FOUND : " + foundNum);
////                System.out.println("ABLE: " + a + " " + tempB);
//                next = foundNum;
//                foundCnt++;
//            }

            if (isAble) {
                foundSet.add(arr[n - 1] * a + tempB);
                foundCnt++;
            }
        }
//        System.out.println(foundCnt);
//        System.out.println(foundCnt == 0 ? "B" : (foundCnt >= 2 ? "A" : next));
        if (foundSet.isEmpty()) System.out.println("B");
        else if (foundSet.size() == 1) System.out.println(foundSet.iterator().next());
        else System.out.println("A");

    }
}
