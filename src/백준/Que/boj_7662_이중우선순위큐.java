package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            int line = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();

            for (int i = 0; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("I")) {
                    int input = Integer.parseInt(st.nextToken());
                    tmap.put(input,tmap.getOrDefault(input,0)+1);
                } else if (command.equals("D")) {
                    int input = Integer.parseInt(st.nextToken());
                    int temp=0;
                    if (tmap.isEmpty()) continue;
                    else {
                        if (input == 1) temp = tmap.lastKey();
                        else temp = tmap.firstKey();

                        if(tmap.put(temp,tmap.get(temp)-1)==1)tmap.remove(temp); //한 숫자가 여러개 들어온 경우
                    }
                }
            }
            if(tmap.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(tmap.lastKey()+" "+tmap.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
