package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_1700_멀티탭스케줄링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int hole = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];
        int[] last = new int[101];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int outHoleCnt = 0;
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {

            if (!hash.contains(arr[i])) {
                if (hash.size() == hole) {
                    //꼳혀 있는 것중에 가장 작은 것을 제거한다.
                    //getMax
                    boolean[] isRemain = new boolean[101];
                    for (int j = i + 1; j < n; j++) {
                        if (hash.contains(arr[j]) && !isRemain[arr[j]]) {
                            isRemain[arr[j]] = true;
                            last[arr[j]] = j;
                        }
                    }

                    //뽑을것
                    //만약 나중에 나오는게 아예 없는 경우
                    int findOutHole = -1;
                    for (Integer key : hash) {
                        if (!isRemain[key]) {
                            findOutHole = key;
                        }
                    }

                    int maxLast = 0;
                    if (findOutHole == -1) {
                        for (Integer key : hash) {
                            if (isRemain[key] && maxLast < last[key]) {
                                maxLast = last[key];
                                findOutHole = key;
                            }
                        }
                    }

                    if (findOutHole == -1) {
                        throw new IOException();
                    }

//                    System.out.println("findOutHole = " + findOutHole);
                    hash.remove(findOutHole);
                    outHoleCnt++;
                }
                hash.add(arr[i]);
            }
        }

        System.out.println(outHoleCnt);

    }
}
