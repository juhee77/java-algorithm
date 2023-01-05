package inflearn.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E_K번쨰큰수 {

    public static int solution2(int[] arr, int n, int k){
        int answer=-1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt=0;
        //Tset.remove(143);
        //System.out.println(Tset.size());
        //System.out.println("first : "+ Tset.first());
        //System.out.println("last : "+ Tset.last());

        for(int x : Tset){
            //System.out.println(x);
            cnt++;
            if(cnt==k) return x;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, arr));
        System.out.println(solution2(arr,N,K));
    }

    private static int solution(int n, int k, int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        HashMap<Integer, Integer> hash3 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            //2-> 3
            for (Integer key : hash2.keySet()) {
                int cnt = hash2.get(key);
                hash3.put(key + arr[i], hash3.getOrDefault(key + arr[i], 0) + cnt);

            }
            //1->2
            for (Integer key : hash.keySet()) {
                int cnt = hash.get(key);
                hash2.put(key + arr[i], hash2.getOrDefault(key + arr[i], 0) + cnt);
            }
            //1
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> collect = hash3.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //System.out.println(collect);
        if(collect.size()<=k-1) return -1;
        return collect.get(k-1);
    }
}
