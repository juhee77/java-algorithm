package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1620_hashtable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        String hashArr[] = new String[n+1];
        for(int i=1;i<=n;i++){
            String temp=br.readLine();
            hash.put(temp,i);
            hashArr[i]=temp;
        }

        for(int i=0;i<m;i++){
            String temp = br.readLine();
            if(hash.containsKey(temp))
                sb.append(hash.get(temp)).append('\n');
            else sb.append(hashArr[Integer.parseInt(temp)]).append('\n');
                //sb.append(getKey(hash,Integer.parseInt(temp))).append('\n');
        }
        System.out.println(sb);
    }

    //key를 찾는 방법
    //value 를 찾는 경우에는 hash.get(temp) 이용
    /*
    public static <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
     */
}
