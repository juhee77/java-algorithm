package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_피보나치재귀 {
    private static int[] fibo = new int[1000000];
    static int[] fibo2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.println();
        for (int i = 1; i <= n; i++) System.out.print(DFS(i)+" ");
        System.out.println();
        fibo2 = new int[n + 1];
        for (int i = 1; i <= n; i++) System.out.print(DFS2(i)+" ");
    }

    private static int solution(int n) {
        if (fibo[n] != 0) return fibo[n];

        if (n <= 2) {
            fibo[n] = 1;
        } else {
            fibo[n] = solution(n - 1) + solution(n - 2);
        }
        System.out.print(fibo[n]+" ");
        return fibo[n];
    }

    public static int DFS2(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n]=DFS(n-2)+DFS(n-1);
    }

    public static int DFS(int n){
        if(n==1) return 1;
        else if(n==2) return 1;
        else return DFS(n-2)+DFS(n-1);
    }
}

//강의 수강률 80% (29/36), (42/53) 검정 1회 응시
