package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_이진수츌력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.println();
        solution2(n);
    }

    private static void solution(int n) {
        if (0 < n) {
            solution(n / 2);
            System.out.print(n%2);
        }
    }

    public static void DFS(int n){
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public static void solution2(int n){
        DFS(n);
    }
}
