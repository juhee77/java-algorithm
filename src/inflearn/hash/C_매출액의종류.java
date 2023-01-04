package inflearn.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C_매출액의종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] day = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        int point = 0;
        for(int i=0;i<N;i++){
            hash.put(day[i],hash.getOrDefault(day[i],0)+1);
            if(K-1<=i){
                sb.append(hash.keySet().size()).append(" ");
                /*다음걸 위에 미리 세팅*/
                int tempCnt = hash.get(day[point]);
                if(tempCnt==1) hash.remove(day[point]);
                else hash.put(day[point],tempCnt-1);
                point++;
            }
        }
        System.out.println(sb);

        for (int x : solution(N, K, day)) {
            System.out.print(x+" ");
        }
    }

    private static ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<k-1;i++){
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            hash.put(arr[rt], hash.getOrDefault(arr[rt], 0) + 1);
            answer.add(hash.size());

            hash.put(arr[lt],hash.get(arr[lt])-1);
            if (hash.get(arr[lt]) == 0)hash.remove(arr[lt]);
            lt++;
        }
        return answer;
    }

}
