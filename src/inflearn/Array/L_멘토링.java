package inflearn.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class L_멘토링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int student = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        int arr[][] = new int[line][student];
        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<student;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기 해시 세팅
        HashSet<String> hash = new HashSet<>();
        for(int p=0;p<student-1;p++){
            for(int j=p+1;j<student;j++){
                String temp = arr[0][p]+" "+arr[0][j];
                //System.out.println(temp);
                hash.add(temp);
            }
        }


        for(int i=0;i<line;i++){
            HashSet<String> tmphash = new HashSet<>();
            for(int p=0;p<student-1;p++){
                for(int j=p+1;j<student;j++){
                    String temp = arr[i][p]+" "+arr[i][j];
                    if(hash.contains(temp)) tmphash.add(temp);
                }
            }
            hash = tmphash;
        }
        System.out.println(hash.size());


    }
}
