package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1208_부분수열의합2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int arr[] = new int[numberCount + 1];

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        long cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= numberCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //들어온 값과 더하면 goal 이되는 값이 있는지 확인
//            if (map.containsKey(goal - arr[i])) {
//                cnt += map.get(goal - arr[i]);
//            }
            if(arr[i]<0) Collections.sort(list);
            else Collections.sort(list,Collections.reverseOrder());

            int sz = list.size();
            for (int j = 0; j < sz; j++) {
                int temp = list.get(j) + arr[i];
                int h = map.get(temp-arr[i]);
                put(list, map, temp, h);
            }

            put(list,map,arr[i],1);

            System.out.println(Arrays.toString(list.toArray()));
//            System.out.println(Arrays.toString(map.keySet().toArray(new Integer[0])));
//            System.out.println(Arrays.toString(map.values().toArray(new Integer[0])));
        }


        System.out.println(map.get(goal));

    }

    private static void put(ArrayList<Integer> list, HashMap<Integer, Integer> map, int temp, int h) {
        if (map.containsKey(temp)) {
            //만약 해쉬에 있으면 넣지 않고 해쉬값만 증가
            map.put(temp, map.get(temp)+ h);
        } else if (temp <= 1000000 && -1000000 <= temp) {
            map.put(temp, 1);
            list.add(temp);
        }
    }

}
/*
10 0
-1 1 -1 1 -1 1 -1 1 -1 1

6 0
-1 1 -1 1 -1 1
 */
