package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1717_집합의표현 {
    private static final int UNION = 0;
    private static final int PRINT = 1;

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        parents = new int[size + 1];

        /*init*/
        for (int i = 0; i <= size; i++) {
            parents[i] = i;
        }


        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == UNION) {
                unionParens(a,b);
            }
            else if (cmd == PRINT) {
                if (findParent(a)== findParent(b))
                    sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(sb);
    }

    static int findParent(int a){
        if(a==parents[a]) return a;
        return parents[a] = findParent(parents[a]);
    }

    static void unionParens(int a,int b){
        //최고 조상을 수정해야함
        a = findParent(a);
        b = findParent(b);
        if(a==b) parents[b]=a;
        else parents[a]=b;
    }

}
