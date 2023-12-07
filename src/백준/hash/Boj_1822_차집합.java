package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1822_차집합 {
    private static final HashSet<Integer> hash = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < a; i++) {
            hash.add(Integer.parseInt(st1.nextToken()));
        }


        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st2.nextToken());
            hash.remove(num);
        }

        Iterator<Integer> iterator = hash.iterator();
        List<Integer> arr = new ArrayList<>();
        while (iterator.hasNext()) {
            arr.add(iterator.next());
        }

        Collections.sort(arr);
        sb.append(arr.size()).append("\n");
        for (Integer integer : arr) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }
}
