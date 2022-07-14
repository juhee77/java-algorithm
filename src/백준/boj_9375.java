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

            int cnt=1;
            for(int i=0;i<hash.size();i++){
                cnt *= combination[i]+1; //옷을 입는 경우가 있으므로  옷수에 +1
            }
            sb.append(cnt-1).append('\n'); //모두 안 입는 겨웅
        }
        System.out.println(sb);

    }
}

/*
1
10
 a a
b a
c b
d b
e b
f b
g c
h d
i d
j d
 */