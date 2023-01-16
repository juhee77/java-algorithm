package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_팩토리얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
        System.out.println(DFS(n));
    }

    private static int solution(int n) {
        if (1 < n) {
            return n * solution(n - 1);
        }
        return 1;
    }

    public static int DFS(int n){
        if(n==1) return 1;
        else return n*DFS(n-1);
    }
}
