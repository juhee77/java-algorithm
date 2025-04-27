package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_32029_지금자면꿈을꾸지만 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.add(0);
        Collections.sort(arr);
        int maxDiff = arr.get(1) - arr.get(0);
        int maxIdx = 1;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) > maxDiff) {
                maxDiff = arr.get(i + 1) - arr.get(i);
                maxIdx = i + 1;
            }
        }

        if (b == 0) {
            System.out.println(n);
            return;
        }

        int maxHw = 0;
        int maxNoHw = 0;
        int now = 0;
        int noSleepNow = a;
        int aa = a;

        for (int i = 1; i <= n; i++) {
            if (maxIdx == i) {
                int x = (b == 1) ? arr.get(i) - a : (arr.get(i) - a) / (b - 1);
                if (x <  0) continue;
                int tempA = a - x;
                if (tempA < 0) continue;
                a = tempA;
                System.out.println(i+" " +x+" "+a);
                if(now==0) now+=a;
                now += b*x ; //수면
            }

            System.out.println(i + " " + a + " " + now + " " + maxHw);
            if (now <= arr.get(i)) {
                maxHw++;
                now += a;
            }

            if(noSleepNow <= arr.get(i)){
                maxNoHw++;
                noSleepNow+=aa;
            }
        }
        System.out.println(maxHw + " " + maxNoHw);
        System.out.println(Math.max(maxHw, maxNoHw));
    }
}
