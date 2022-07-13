package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public class boj_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            int clothes = Integer.parseInt(br.readLine());
            Hashtable<String, Integer> hash = new Hashtable<>();

            for (int c = 0; c < clothes; c++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                if (hash.containsKey(type)) hash.put(type, hash.get(type) + 1);
                else hash.put(type, 1);
            }

            Iterator<String> iterator = hash.keySet().iterator();
            /*
            while (iterator.hasNext()) {
                int test = hash.get(iterator.next());
                System.out.println(test);
            }*/
            Integer combination[] = hash.values().toArray(new Integer[hash.size()]);
            //System.out.println(Arrays.toString(combination));
            int cnt = 0;
            for (int i = 0; i < hash.size(); i++) {
                int j = i + 1;
                int temp = 0;
                for (; j < hash.size(); j++) {
                    combination[i] = combination[i] * combination[j];
                }

                for (j = hash.size() - 1; i <= j; j--) {
                    cnt += combination[i];
                    combination[i] = combination[i] / combination[j];
                }

                cnt += temp;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);

    }
}
