package 백준.Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2465_카드2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i =1;i<=a;i++) queue.add(i);

        boolean flag = true;
        while(queue.size() > 1){
            if(flag) queue.remove();
            else{
                int tmp = queue.poll();
                queue.add(tmp);
            }
            //System.out.println(queue.toString());
            flag = !flag;
        }
        System.out.println(queue.poll());

    }
}
