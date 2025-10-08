package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_25496_장신구명장임스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int energy = 200-Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> costs  = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            costs.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(costs);
        int maxAccessoriesCount = 0;
        while (0<energy && maxAccessoriesCount<n){
            energy-= costs.get(maxAccessoriesCount);
            maxAccessoriesCount++;
        }
        System.out.println(maxAccessoriesCount);
    }
}
