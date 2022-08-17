package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_11723 {
    static HashSet<Integer> Allhash = new HashSet<Integer>();
    public static void before(){
        for(int i=1;i<=20;i++)Allhash.add(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int cnt = Integer.parseInt(st.nextToken());
        HashSet<Integer> hash = new HashSet<Integer>();
        before();

        for(int i=0;i<cnt;i++){

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int input = Integer.parseInt(st.nextToken());
                hash.add(input);
            }
            else if(command.equals("remove")){
                int input = Integer.parseInt(st.nextToken());
                if(hash.contains(input))hash.remove(input);
            }
            else if(command.equals("check")){
                int input = Integer.parseInt(st.nextToken());
                int re = (hash.contains(input))?1:0;
                sb.append(re).append('\n');
            }

            else if(command.equals("toggle")){
                int input = Integer.parseInt(st.nextToken());
                if(hash.contains(input))hash.remove(input);
                else hash.add(input);
            }
            else if(command.equals("all")){
                hash = (HashSet<Integer>) Allhash.clone();
            }
            else if(command.equals("empty")){
                hash.clear();
            }
            else{
                sb.append("check rule \n");
            }
        }

        System.out.println(sb);

    }
}
