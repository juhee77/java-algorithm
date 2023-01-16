package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_재귀함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.println();
        solution2(n);
    }

    private static void solution(int n) {
        if (n<=0) {
            return;
        }
        solution(n - 1);
        System.out.print(n+" ");
    }


    public static void DFS(int n){
        if(n==0) {
            return;
        } else{
            DFS(n-1);
            System.out.print(n+" ");
        }
    }

    public static void solution2(int n){
        DFS(n);
    }
}
