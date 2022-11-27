package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class boj_5052_전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int line = Integer.parseInt(br.readLine());
            List<String> number = new ArrayList<>();
            for(int i=0;i<line;i++){
                number.add(br.readLine());
            }
            number.sort(Comparator.comparingInt(String::length));
            sb.append(checkinNumber(line, number)).append("\n");
        }
        System.out.println(sb);
    }

    private static String checkinNumber(int line, List<String> number) {
        HashSet<String > numberBook = new HashSet<>();
        int maxLen = 0;
        for(int i = 0; i< line; i++){
            String now = number.get(i);
            for(int j=0;j<maxLen;j++){
                if(numberBook.contains(now.substring(0,j+1))) return "NO";
            }

            numberBook.add(now);
            maxLen = now.length();
        }
        return "YES";
    }
}
