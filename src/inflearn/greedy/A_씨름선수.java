package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_씨름선수 {
    private static class Player implements Comparable<Player>{
        int height, weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player o) {
            return o.height-this.height; //키가 큰 사람부터 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        Player[] arr = new Player[x];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Player(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        int ans = 0;
        int max = Integer.MIN_VALUE; //키카 큰 사람부터 정렬되어 있으므로 만약 뒤에서 나오는 사람이 키가 더 크면 선수가 될수 있음
        for (Player player : arr) {
            if(player.weight>max){
                max = player.weight;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
