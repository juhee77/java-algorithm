package 백준;
//안되면 자료형 부터 확인!!!!제발..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9184 {
    static long arr[][][] = new long[51][51][51];
    static long recursion(int a, int b, int c){


        if(a<=0 || b<=0 || c<=0) return 1;
        else if(arr[a][b][c]!=0)return arr[a][b][c];
        else if(a>20 || b>20|| c>20) arr[a][b][c]=recursion(20,20,20);
        else if(a<b &&b<c ) arr[a][b][c]=recursion(a,b,c-1)+recursion(a,b-1,c-1)-recursion(a,b-1,c);
        else arr[a][b][c]= recursion(a-1,b,c)+recursion(a-1,b-1,c)+recursion(a-1,b,c-1)-recursion(a-1,b-1,c-1);

        return arr[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ///int n = Integer.parseInt(br.readLine());
        ///st = new StringTokenizer(br.readLine());
        arr[0][0][0]=1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a==b&&b==c&&c==-1) break;

            long n = recursion(a,b,c);
            System.out.println("w("+a+", "+b+", "+c+") = "+n);
        }

    }
}
