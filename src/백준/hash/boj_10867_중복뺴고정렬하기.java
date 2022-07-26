package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_10867_중복뺴고정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        HashSet<Integer> hash = new HashSet<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<line;i++){
            hash.add(Integer.parseInt(st.nextToken()));
        }

        Integer arr[] = hash.toArray(new Integer[hash.size()]);
        Arrays.sort(arr);
        for(int i=0 ;i<hash.size();i++){
            sb.append(arr[i]+" ");
        }


        System.out.println(sb);
    }
}
