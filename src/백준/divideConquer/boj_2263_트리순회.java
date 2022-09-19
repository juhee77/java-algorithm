package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2263_트리순회 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] post;
    private static int[] in;

    public static void check(int istart, int iend, int pstart, int pend) {

        if ( iend < istart || pend < pstart ) return;
        //System.out.println(Arrays.toString(Arrays.copyOfRange(in, istart, iend+1)) + Arrays.toString(Arrays.copyOfRange(post, pstart, pend+1)) );

        int inpoint = 0;
        int point = post[pend];
        //System.out.println(point);
        sb.append(point+" ");

        for (inpoint = istart; inpoint <= iend; inpoint++) {
            if (in[inpoint] == point) break;
        }

        check(istart, inpoint-1,pstart,pstart+inpoint-istart-1);
        check(inpoint+1, iend,pstart+inpoint-istart,pend-1);

        //System.out.println(Arrays.toString(ans));

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());
        post=new int[line];
        in=new int[line];

        //입력구간 (inorder)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < line; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        //post order
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < line; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        check(0, line-1,0,line-1);

        System.out.println(sb);
    }
}

/*7
6 4 7 2 5 1 3
6 7 4 5 2 3 1*/
/*

6
4 2 5 1 3 6
4 5 2 6 3 1
11
8 4 2 9 5 1 10 6 3 11 7
8 4 9 5 2 10 6 11 7 3 1
 */