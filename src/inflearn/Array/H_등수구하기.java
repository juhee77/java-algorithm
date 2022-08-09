package inflearn.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class H_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer>hash = new HashMap<Integer,Integer>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<num;i++)
            arr.add(Integer.parseInt(st.nextToken()));
        ArrayList<Integer> clone = (ArrayList<Integer>) arr.clone();

        Collections.sort(arr,Collections.reverseOrder());
        int rank = 0;
        for(int i=0;i<num;i++){
            if(!hash.containsKey(arr.get(i))) {
                hash.put(arr.get(i),rank);
            }
            rank++;
        }

        for(int i=0;i<num;i++){
            clone.set(i,hash.get(clone.get(i)));
        }

        for(int i=0;i<num;i++) sb.append(clone.get(i)+1+" ");

        System.out.println(sb);
    }
}
