package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_1700_멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int hole = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];
        int[] cnt = new int[101];
        int[] last = new int[101];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
            last[arr[i]] = i;
        }

        int outHole = 0;
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            //하나 사용함 우선순위 큐? 에서 뺀다.
            cnt[arr[i]]--;

            if (hash.contains(arr[i])) {
                continue;
            } else {
                if (hash.size() == hole) {
                    //꼳혀 있는 것중에 가장 작은 것을 제거한다.
                    //getMax
                    int minCnt = 100000;
                    int minHole = 0;
                    for (Integer key : hash) {
                        if (cnt[key] < minCnt) {
                            minCnt = cnt[key];
                            minHole = key;
                        } else if (cnt[key] == minCnt && last[minCnt] > last[cnt[key]]) {
                            minCnt = cnt[key];
                            minHole = key;
                        }
                    }

                    //뽑을것
                    outHole++;
                    System.out.println(minHole);
                    hash.remove(minHole);
                }
                hash.add(arr[i]);
            }
        }

        System.out.println(outHole);

    }
}
