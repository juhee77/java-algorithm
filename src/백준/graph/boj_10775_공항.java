package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10775_공항 {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gate = Integer.parseInt(br.readLine());

        int airPlain = Integer.parseInt(br.readLine());

        parents = new int[gate];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int ans =1;
        for (; ans <= airPlain; ans++) {
            int nowGate = Integer.parseInt(br.readLine())-1;
            int available = findParents(nowGate);
            if(available==-1) break;
            parents[available] = available - 1; //이전 게이트로 가라
        }
        System.out.println(ans - 1);
    }

    private static int findParents(int nowGate) { //가능한 게이트를 찾는다
        if(nowGate==-1) return -1; //만약 가능한 게이트가 없다면
        if(parents[nowGate]==nowGate) return nowGate;
        else return parents[nowGate] = findParents(parents[nowGate]);
    }
}
